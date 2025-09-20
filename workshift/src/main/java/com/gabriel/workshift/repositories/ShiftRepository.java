package com.gabriel.workshift.repositories;

import com.gabriel.workshift.domain.sector.shift.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.Optional;

public interface ShiftRepository extends JpaRepository<Shift, String> {

    Optional<Shift> findByShiftStartAndShiftEnd(LocalTime shiftStart, LocalTime shiftEnd);
}
