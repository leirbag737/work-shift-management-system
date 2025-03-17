CREATE TABLE shift_type (
    id CHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    work_hours INT NOT NULL,
    rest_hours INT NOT NULL
)