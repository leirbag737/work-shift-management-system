CREATE TABLE professional_document (

    id CHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    document_type VARCHAR(255) NOT NULL,
    document_number VARCHAR(255) NOT NULL UNIQUE,
    employee_id CHAR(36),
    job_title_id CHAR(36),

    CONSTRAINT fk_professional_document_employee FOREIGN KEY (employee_id) REFERENCES employee(id),
    CONSTRAINT fk_professional_document_job_title FOREIGN KEY (job_title_id) REFERENCES job_title(id)

);