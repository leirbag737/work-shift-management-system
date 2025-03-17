package com.gabriel.workshift.domain.employee.statusHistory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.workshift.domain.employee.Employee;
import com.gabriel.workshift.domain.employee.enums.EmployeeStatus;
import com.gabriel.workshift.domain.employee.enums.converters.EmployeeStatusConverter;
import com.gabriel.workshift.utils.enums.Status;
import com.gabriel.workshift.utils.enums.converters.StatusConverter;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class EmployeeStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Convert(converter = StatusConverter.class)
    private Status statusEmployeeStatusHistory;

    @Convert(converter = EmployeeStatusConverter.class)
    private EmployeeStatus employeeStatus;

    private LocalDate stardDate;

    private LocalDate endDate;

    private String observation;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    public EmployeeStatusHistory() {
    }

    public EmployeeStatusHistory(EmployeeStatus employeeStatus, LocalDate stardDate, LocalDate endDate, String observation, Employee employee) {
        this.employeeStatus = employeeStatus;
        this.stardDate = stardDate;
        this.endDate = endDate;
        this.observation = observation;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public LocalDate getStardDate() {
        return stardDate;
    }

    public void setStardDate(LocalDate stardDate) {
        this.stardDate = stardDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
