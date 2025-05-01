package com.gabriel.workshift.services;

import com.gabriel.workshift.domain.employee.Employee;
import com.gabriel.workshift.domain.employee.dto.EmployeePageDTO;
import com.gabriel.workshift.domain.employee.dto.EmployeeRequestDTO;
import com.gabriel.workshift.domain.employee.dto.EmployeeResponseDTO;
import com.gabriel.workshift.domain.employee.dto.mapper.EmployeeMapper;
import com.gabriel.workshift.exceptions.RecordNotFoundException;
import com.gabriel.workshift.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProfessionalDocumentService professionalDocumentService;

    @Autowired
    private EmployeeMapper employeeMapper;


    @Transactional
    public Employee create(EmployeeRequestDTO data) {

        Employee newEmployee = employeeMapper.employeeRequestDtoToEmployeeEntity(data);
        employeeRepository.save(newEmployee);

        userService.create(data.user(), newEmployee);

        newEmployee.setProfessionalDocuments(professionalDocumentService.create(data.professionalDocuments(), newEmployee));

        return newEmployee;
    }

    public List<EmployeeResponseDTO> list() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::employeeEntityToEmployeeResponseDto)
                .toList();
    }

    public EmployeePageDTO list(@PositiveOrZero int page, @Positive @Max(1000) int pageSize) {

        Page<Employee> employeePage = employeeRepository.findAll(PageRequest.of(page, pageSize));

        List<EmployeeResponseDTO> list = employeePage.getContent().stream()
                .map(employeeMapper::employeeEntityToEmployeeResponseDto)
                .toList();

        return new EmployeePageDTO(list, employeePage.getTotalElements(), employeePage.getTotalPages());
    }

    public EmployeeResponseDTO getById(@NotNull String id) {
        return employeeMapper.employeeEntityToEmployeeResponseDto(
                employeeRepository.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException(id))
        );
    }

    public EmployeeResponseDTO update(@NotNull String id, @Valid EmployeeRequestDTO data) {
        return employeeRepository.findById(id).
                map(employeeToUpdated -> {

                    employeeToUpdated.setName(data.name());
                    employeeToUpdated.setPersonalDocumentType(data.personalDocumentType());
                    employeeToUpdated.setPersonalDocument(data.personalDocument());
                    employeeToUpdated.setEmail(data.email());
                    employeeToUpdated.setPhoneNumber(data.phoneNumber());
                    updateEmployeeStatusIfChanged(employeeToUpdated, data);

                    // the update of these attributes will happen later because they need more validation.

                    // employeeToUpdated.setContractType(data.contractType());
                    // employeeToUpdated.setShiftType(data.shiftType());
                    // employeeToUpdated.setJobTitle(new JobTitle());

                    return employeeMapper.employeeEntityToEmployeeResponseDto(employeeRepository.save(employeeToUpdated));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    private void updateEmployeeStatusIfChanged(Employee updatedEmployee, EmployeeRequestDTO data) {
        if (data.employeeStatus() == null ||
                data.employeeStatus().getEmployeeStatus().equals(updatedEmployee.getEmployeeStatus())) {
            return;
        }
        updatedEmployee.addEmployeeStatus(data.employeeStatus());
    }
}
