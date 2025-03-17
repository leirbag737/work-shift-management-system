package com.gabriel.workshift.domain.employee.enums;

public enum ContractType {

    FULL_TIME ("full_time"),
    INTERMITTENT("intermittent");

    private String value;

    private ContractType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
