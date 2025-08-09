package com.gabriel.workshift.domain.documents.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriel.workshift.domain.documents.DocumentType;

public record ProfessionalDocumentResponseDTO(

        String id,

        DocumentType documentType,

        String documentNumber,

        String observation
) {
}
