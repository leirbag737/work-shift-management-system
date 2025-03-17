package com.gabriel.workshift.domain.employee.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriel.workshift.domain.employee.enums.ContractType;
import com.gabriel.workshift.domain.documents.DocumentType;
import com.gabriel.workshift.domain.documents.dto.ProfessionalDocumentRequestDTO;
import com.gabriel.workshift.domain.employee.shiftType.ShiftType;
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
        @JsonProperty("personal_document_type")
        DocumentType personalDocumentType,

        @NotNull
        @NotBlank
        @JsonProperty("personal_document")
        String personalDocument,

        @NotNull
        @JsonProperty("contract_type")
        ContractType contractType,

        @NotNull
        @NotBlank
        String email,

        @NotNull
        @NotBlank
        String phoneNumber,

        @NotNull
        RegisterDTO user,

        @JsonProperty("shift_type")
        ShiftType shiftType,

        @NotNull
        @JsonProperty("job_title")
        JobTitle jobTitle,

        @JsonProperty("professional_documents")
        List<ProfessionalDocumentRequestDTO> professionalDocuments
) {
}
