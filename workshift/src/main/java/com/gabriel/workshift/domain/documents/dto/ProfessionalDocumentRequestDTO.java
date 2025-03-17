package com.gabriel.workshift.domain.documents.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriel.workshift.domain.documents.DocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfessionalDocumentRequestDTO(

        @NotNull
        @JsonProperty("document_type")
        DocumentType documentType,

        @NotNull
        @NotBlank
        @JsonProperty("document_number")
        String documentNumber,

        String observation
) {
}
