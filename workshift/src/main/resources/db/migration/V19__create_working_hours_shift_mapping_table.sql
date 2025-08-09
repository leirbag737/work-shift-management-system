CREATE TABLE working_hours_shift_mapping (
    working_hours_id CHAR(36) NOT NULL,
    shift_id CHAR(36) NOT NULL,

    PRIMARY KEY (working_hours_id, shift_id),
    FOREIGN KEY (working_hours_id) REFERENCES working_hours(id),
    FOREIGN KEY (shift_id) REFERENCES shift(id)
);