package com.gabriel.workshift.controllers;

import com.gabriel.workshift.domain.sector.shift.Shift;
import com.gabriel.workshift.domain.sector.shift.dto.ShiftRequestDTO;
import com.gabriel.workshift.domain.sector.workingHours.WorkingHours;
import com.gabriel.workshift.domain.sector.workingHours.dto.WorkingHoursRequestDTO;
import com.gabriel.workshift.services.ShiftService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shift")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    @PostMapping
    public ResponseEntity<Shift> create(@RequestBody @Valid ShiftRequestDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shiftService.create(data));
    }
}
