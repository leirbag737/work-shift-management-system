ALTER TABLE users
    ADD COLUMN employee_id CHAR(36);

ALTER TABLE users
    ADD CONSTRAINT fk_user_employee_id FOREIGN KEY(employee_id) REFERENCES employee(id);