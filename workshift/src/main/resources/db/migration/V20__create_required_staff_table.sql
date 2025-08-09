CREATE TABLE required_staff (
    id CHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    status VARCHAR(20) NOT NULL,
    min_staff INT NOT NULL,
    max_staff INT,
    job_title_id CHAR(36) NOT NULL,
    shift_id CHAR(36) NOT NULL,

    FOREIGN KEY (job_title_id) REFERENCES job_title(id),
    FOREIGN KEY (shift_id) REFERENCES shift(id)
);