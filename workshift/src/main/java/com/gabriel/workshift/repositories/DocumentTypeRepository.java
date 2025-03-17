package com.gabriel.workshift.repositories;

import com.gabriel.workshift.domain.documents.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, String> {
}
