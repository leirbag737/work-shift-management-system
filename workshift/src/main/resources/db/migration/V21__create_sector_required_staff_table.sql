CREATE TABLE sector_required_staff (
    id CHAR(36) PRIMARY KEY UNIQUE NOT NULL,
    status VARCHAR(20) NOT NULL,
    sector_id CHAR(36) NOT NULL
);