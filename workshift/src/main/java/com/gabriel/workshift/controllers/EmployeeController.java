package com.gabriel.workshift.controllers;

import com.gabriel.workshift.domain.employee.Employee;
import com.gabriel.workshift.domain.employee.dto.EmployeePageDTO;
import com.gabriel.workshift.domain.employee.dto.EmployeeRequestDTO;
import com.gabriel.workshift.domain.employee.dto.EmployeeResponseDTO;
import com.gabriel.workshift.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody @Valid EmployeeRequestDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(data));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeResponseDTO>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.list());
    }

    @GetMapping
    public ResponseEntity<EmployeePageDTO> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.list(page, pageSize));
    }
}
