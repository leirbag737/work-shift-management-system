package com.gabriel.workshift.repositories;

import com.gabriel.workshift.domain.documents.ProfessionalDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalDocumentRepository extends JpaRepository<ProfessionalDocument, String> {
}
