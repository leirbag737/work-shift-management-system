package com.gabriel.workshift.domain.employee.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriel.workshift.domain.employee.enums.ContractType;
import com.gabriel.workshift.domain.documents.DocumentType;
import com.gabriel.workshift.domain.documents.dto.ProfessionalDocumentRequestDTO;
import com.gabriel.workshift.domain.employee.shiftType.ShiftType;
import com.gabriel.workshift.domain.employee.statusHistory.EmployeeStatusHistory;
import com.gabriel.workshift.domain.jobTitle.JobTitle;
import com.gabriel.workshift.domain.user.dto.RegisterDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EmployeeRequestDTO(

        @NotNull
        @NotBlank
        String name,

        @NotNull
        DocumentType personalDocumentType,

        @NotNull
        @NotBlank
        String personalDocument,

        @NotNull
        ContractType contractType,

        @NotNull
        @NotBlank
        String email,

        @NotNull
        @NotBlank
        String phoneNumber,

        @NotNull
        RegisterDTO user,

        ShiftType shiftType,

        @NotNull
        JobTitle jobTitle,

        List<ProfessionalDocumentRequestDTO> professionalDocuments,

        EmployeeStatusHistory employeeStatus
) {
}
