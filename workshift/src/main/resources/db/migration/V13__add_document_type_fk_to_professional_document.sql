ALTER TABLE professional_document ADD COLUMN document_type_id CHAR(36);
ALTER TABLE professional_document ADD CONSTRAINT fk_professional_document_document_type FOREIGN KEY (document_type_id) REFERENCES document_type(id);