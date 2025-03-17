package com.gabriel.workshift.controllers;

import com.gabriel.workshift.domain.jobTitle.dto.JobTitlePageDTO;
import com.gabriel.workshift.domain.jobTitle.dto.JobTitleRequestDTO;
import com.gabriel.workshift.domain.jobTitle.dto.JobTitleResponseDTO;
import com.gabriel.workshift.services.JobTitleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-titles")
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;


    @PostMapping
    public ResponseEntity<JobTitleResponseDTO> create(@RequestBody JobTitleRequestDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobTitleService.create(data));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<JobTitleResponseDTO> getById(@PathVariable @NotNull String id) {
        return ResponseEntity.status(HttpStatus.OK).body(jobTitleService.getById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<JobTitleResponseDTO>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(jobTitleService.list());
    }

    @GetMapping()
    public ResponseEntity<JobTitlePageDTO> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize){
        return ResponseEntity.status(HttpStatus.OK).body(jobTitleService.list(page, pageSize));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobTitleResponseDTO> update(@PathVariable @NotNull String id, @RequestBody @Valid JobTitleRequestDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(jobTitleService.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @NotNull String id) {
        jobTitleService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
