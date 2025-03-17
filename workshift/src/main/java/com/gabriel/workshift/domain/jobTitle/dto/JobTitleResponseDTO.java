package com.gabriel.workshift.domain.jobTitle.dto;

import com.gabriel.workshift.domain.jobTitle.JobTitle;

public record JobTitleResponseDTO(String id, String name) {

    public JobTitleResponseDTO(JobTitle jobTitle) {
        this(jobTitle.getId(), jobTitle.getName());
    }
}
