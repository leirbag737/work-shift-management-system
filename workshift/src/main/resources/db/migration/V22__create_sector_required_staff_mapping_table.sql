CREATE TABLE sector_required_staff_mapping (
    sector_required_staff_id CHAR(36) NOT NULL,
    required_staff_id CHAR(36) NOT NULL,

    PRIMARY KEY (sector_required_staff_id, required_staff_id),
    FOREIGN KEY (sector_required_staff_id) REFERENCES sector_required_staff(id),
    FOREIGN KEY (required_staff_id) REFERENCES required_staff(id)
);