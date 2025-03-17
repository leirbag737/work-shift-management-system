CREATE TABLE employee_status_history (

    id CHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    status_employee_status_history VARCHAR(36),
    employee_status VARCHAR(36),
    start_date DATE,
    end_date DATE,
    observation TEXT,
    employee_id CHAR(36),

    CONSTRAINT fk_employee_status_history_employee FOREIGN KEY (employee_id) REFERENCES employee(id)

);
