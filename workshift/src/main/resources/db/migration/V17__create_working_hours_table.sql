CREATE TABLE working_hours (
    id CHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    status VARCHAR(20) NOT NULL,
    description VARCHAR(255),
    days_of_week VARCHAR(255),
    standard_time BOOLEAN NOT NULL,
    opening_time TIME,
    closing_time TIME,
    effective_start_date TIMESTAMP,
    effective_end_date TIMESTAMP,
    number_shifts INT NOT NULL
);