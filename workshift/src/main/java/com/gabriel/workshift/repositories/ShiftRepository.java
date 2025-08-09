package com.gabriel.workshift.repositories;

import com.gabriel.workshift.domain.sector.shift.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, String> {
}
