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

        EmployeeStatus employeeStatus,

        String name,

        DocumentType personalDocumentType,

        String personalDocument,

        ContractType contractType,

        String email,

        String phoneNumber,

        ShiftType shiftType,

        JobTitle jobTitle,

        List<ProfessionalDocumentResponseDTO> professionalDocuments
) {
}
