package com.gabriel.workshift.domain.employee.dto;

import java.util.List;

public record EmployeePageDTO(
        List<EmployeeResponseDTO> employees,
        long totalElements,
        int totalPages
) {
}
