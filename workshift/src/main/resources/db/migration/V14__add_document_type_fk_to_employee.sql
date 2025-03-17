ALTER TABLE employee DROP COLUMN personal_document_type;
ALTER TABLE employee ADD COLUMN document_type_id CHAR(36);

ALTER TABLE employee ADD CONSTRAINT fk_employee_document_type FOREIGN KEY (document_type_id) REFERENCES document_type(id) ON DELETE SET NULL;