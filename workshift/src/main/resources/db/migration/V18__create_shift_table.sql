CREATE TABLE shift (
    id CHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    status VARCHAR(20) NOT NULL,
    shift_start TIME NOT NULL,
    shift_end TIME NOT NULL
);