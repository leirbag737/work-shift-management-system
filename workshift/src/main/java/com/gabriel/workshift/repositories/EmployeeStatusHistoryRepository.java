package com.gabriel.workshift.repositories;

import com.gabriel.workshift.domain.employee.statusHistory.EmployeeStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeStatusHistoryRepository extends JpaRepository<EmployeeStatusHistory, String> {
}
