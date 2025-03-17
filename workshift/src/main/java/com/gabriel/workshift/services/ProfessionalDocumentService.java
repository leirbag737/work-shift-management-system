package com.gabriel.workshift.services;

import com.gabriel.workshift.domain.employee.Employee;
import com.gabriel.workshift.domain.documents.ProfessionalDocument;
import com.gabriel.workshift.domain.documents.dto.ProfessionalDocumentRequestDTO;
import com.gabriel.workshift.repositories.ProfessionalDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProfessionalDocumentService {

    private static final Logger log = LoggerFactory.getLogger(ProfessionalDocumentService.class);

    @Autowired
    private ProfessionalDocumentRepository professionalDocumentRepository;


    public Set<ProfessionalDocument> create(List<ProfessionalDocumentRequestDTO> data, Employee employee) {

        if (data == null || employee == null) {
            throw new IllegalArgumentException("The list of professional documents and employee cannot be null.");
        }

        data.forEach(documentRequestDTO -> {
            if (documentRequestDTO.documentType() == null || documentRequestDTO.documentNumber() == null) {
                throw new IllegalArgumentException("Document type and document number cannot be null.");
            }
        });

        return data.stream()
                .map(documentRequestDTO -> professionalDocumentRepository.save(
                        new ProfessionalDocument(
                                documentRequestDTO.documentType(),
                                documentRequestDTO.documentNumber(),
                                employee
                        )
                ))
                .collect(Collectors.toSet());
    }
}
