package com.gabriel.workshift.repositories;

import com.gabriel.workshift.domain.employee.shiftType.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftTypeRepository extends JpaRepository<ShiftType, String> {
}
