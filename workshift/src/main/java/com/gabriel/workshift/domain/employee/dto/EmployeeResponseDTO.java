package com.gabriel.workshift.domain.employee.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriel.workshift.domain.documents.dto.ProfessionalDocumentResponseDTO;
import com.gabriel.workshift.domain.employee.enums.ContractType;
import com.gabriel.workshift.domain.employee.enums.EmployeeStatus;
import com.gabriel.workshift.domain.employee.shiftType.ShiftType;
import com.gabriel.workshift.domain.jobTitle.JobTitle;
import com.gabriel.workshift.domain.documents.DocumentType;

import java.util.List;

public record EmployeeResponseDTO(

        String id,

        @JsonProperty("employee_status")
        EmployeeStatus employeeStatus,

        String name,

        @JsonProperty("personal_document_type")
        DocumentType personalDocumentType,

        @JsonProperty("personal_document")
        String personalDocument,

        @JsonProperty("contract_type")
        ContractType contractType,

        String email,

        @JsonProperty("phone_number")
        String phoneNumber,

        @JsonProperty("shift_type")
        ShiftType shiftType,

        @JsonProperty("job_title")
        JobTitle jobTitle,

        @JsonProperty("professional_documents")
        List<ProfessionalDocumentResponseDTO> professionalDocuments
) {
}
