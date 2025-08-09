CREATE TABLE sector (
    id CHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    status VARCHAR(20) NOT NULL,
    name VARCHAR(255) NOT NULL,
    continuos_operation BOOLEAN NOT NULL,
    working_hours_id CHAR(36) NOT NULL,
    sector_required_staff_id CHAR(36) NOT NULL,

    FOREIGN KEY (working_hours_id) REFERENCES working_hours(id),
    FOREIGN KEY (sector_required_staff_id) REFERENCES sector_required_staff(id)
);