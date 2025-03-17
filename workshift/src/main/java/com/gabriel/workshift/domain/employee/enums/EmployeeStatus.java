package com.gabriel.workshift.domain.employee.enums;

public enum EmployeeStatus {

    ACTIVE("active"),
    INACTIVE("inactive"),
    ON_LEAVE("on_leave"),
    AWAY("away");

    private String value;

    private EmployeeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
