package com.gabriel.workshift.domain.documents.dto.mapper;

import com.gabriel.workshift.domain.documents.ProfessionalDocument;
import com.gabriel.workshift.domain.documents.dto.ProfessionalDocumentResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfessionalDocumentMapper {

    public ProfessionalDocumentResponseDTO professionalDocumentEntityToDto(ProfessionalDocument entity) {
        return new ProfessionalDocumentResponseDTO(entity.getId(), entity.getDocumentType(), entity.getDocumentNumber(), entity.getObservation());
    }
}
