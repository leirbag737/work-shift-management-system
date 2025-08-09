ALTER TABLE sector_required_staff
ADD CONSTRAINT fk_sector_required_staff_sector
FOREIGN KEY (sector_id) REFERENCES sector(id);