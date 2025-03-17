package com.gabriel.workshift.domain.employee.dto.mapper;

import com.gabriel.workshift.domain.documents.dto.ProfessionalDocumentResponseDTO;
import com.gabriel.workshift.domain.documents.dto.mapper.ProfessionalDocumentMapper;
import com.gabriel.workshift.domain.employee.Employee;
import com.gabriel.workshift.domain.employee.dto.EmployeeRequestDTO;
import com.gabriel.workshift.domain.employee.dto.EmployeeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {

    @Autowired
    private ProfessionalDocumentMapper professionalDocumentMapper;

    public Employee employeeRequestDtoToEmployeeEntity(EmployeeRequestDTO dto) {

        return new Employee(
                dto.name(),
                dto.personalDocumentType(),
                dto.personalDocument(),
                dto.contractType(),
                dto.email(),
                dto.phoneNumber(),
                dto.shiftType(),
                dto.jobTitle());
    }

    public EmployeeResponseDTO employeeEntityToEmployeeResponseDto(Employee entity) {

        List<ProfessionalDocumentResponseDTO> professionalDocumentList = entity.getProfessionalDocuments().stream()
                .map(professionalDocumentMapper::professionalDocumentEntityToDto)
                .toList();

        return new EmployeeResponseDTO(
                entity.getId(),
                entity.getEmployeeStatus(),
                entity.getName(),
                entity.getPersonalDocumentType(),
                entity.getPersonalDocument(),
                entity.getContractType(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getShiftType(),
                entity.getJobTitle(),
                professionalDocumentList
        );
    }

//    private List<ProfessionalDocument> professionalDocumentsDtoToEntity(List<ProfessionalDocumentRequestDTO> list) {
//
//        List<ProfessionalDocument> newList = new ArrayList<>();
//
//        list.forEach(i -> {
//            newList.add(new)
//        });
//    }
}
