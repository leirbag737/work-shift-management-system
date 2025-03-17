CREATE TABLE employee (

    id CHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    employee_status VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    personal_document_type VARCHAR(36) NOT NULL,
    personal_document VARCHAR(255) NOT NULL UNIQUE,
    contract_type VARCHAR(36) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(36) NOT NULL UNIQUE,
    shift_type_id CHAR(36),
    job_title_id CHAR(36),

    CONSTRAINT fk_employee_shift_type FOREIGN KEY (shift_type_id) REFERENCES shift_type(id),
    CONSTRAINT fk_job_title FOREIGN KEY (job_title_id) REFERENCES job_title(id)

);