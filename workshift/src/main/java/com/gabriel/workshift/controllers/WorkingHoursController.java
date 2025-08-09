package com.gabriel.workshift.controllers;

import com.gabriel.workshift.domain.employee.Employee;
import com.gabriel.workshift.domain.employee.dto.EmployeeRequestDTO;
import com.gabriel.workshift.domain.sector.workingHours.WorkingHours;
import com.gabriel.workshift.domain.sector.workingHours.dto.WorkingHoursRequestDTO;
import com.gabriel.workshift.services.WorkingHoursService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/working-hours")
public class WorkingHoursController {

    @Autowired
    private WorkingHoursService workingHoursService;

    @PostMapping
    public ResponseEntity<WorkingHours> create(@RequestBody @Valid WorkingHoursRequestDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workingHoursService.create(data));
    }
}
