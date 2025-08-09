package com.gabriel.workshift.domain.documents.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriel.workshift.domain.documents.DocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfessionalDocumentRequestDTO(

        @NotNull
        DocumentType documentType,

        @NotNull
        @NotBlank
        String documentNumber,

        String observation
) {
}
