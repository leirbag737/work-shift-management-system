package com.gabriel.workshift.domain.employee.shiftType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.workshift.domain.employee.Employee;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ShiftType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private int workHours;

    private int restHours;

    @OneToMany(mappedBy = "shiftType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Employee> employeeList = new HashSet<>();

    public ShiftType() {
    }

    public ShiftType(String name, int workHours, int restHours) {
        this.name = name;
        this.workHours = workHours;
        this.restHours = restHours;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getRestHours() {
        return restHours;
    }

    public void setRestHours(int restHours) {
        this.restHours = restHours;
    }
}
