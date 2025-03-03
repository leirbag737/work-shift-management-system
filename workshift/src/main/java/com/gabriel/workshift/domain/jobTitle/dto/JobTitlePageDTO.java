package com.gabriel.workshift.domain.jobTitle.dto;

import java.util.List;

public record JobTitlePageDTO(
        List<JobTitleResponseDTO> jobTitles,
        long totalElements,
        int totalPages
) {
}
