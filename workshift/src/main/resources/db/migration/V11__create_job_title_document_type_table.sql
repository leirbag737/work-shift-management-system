CREATE TABLE job_title__document_type (

    job_title_id CHAR(36) NOT NULL,
    document_type_id CHAR(36) NOT NULL,

    PRIMARY KEY (job_title_id, document_type_id),
    FOREIGN KEY (job_title_id) REFERENCES job_title(id) ON DELETE CASCADE,
    FOREIGN KEY (document_type_id) REFERENCES document_type(id) ON DELETE CASCADE

);