package com.gabriel.workshift.domain.documents.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriel.workshift.domain.documents.DocumentType;

public record ProfessionalDocumentResponseDTO(

        String id,

        @JsonProperty("document_type")
        DocumentType documentType,

        @JsonProperty("document_number")
        String documentNumber,

        String observation
) {
}
