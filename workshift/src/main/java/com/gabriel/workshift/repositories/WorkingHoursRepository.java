package com.gabriel.workshift.repositories;

import com.gabriel.workshift.domain.sector.workingHours.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingHoursRepository extends JpaRepository<WorkingHours, String> {
}
