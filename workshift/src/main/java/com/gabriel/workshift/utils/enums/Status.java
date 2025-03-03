package com.gabriel.workshift.utils.enums;

public enum Status {

    ACTIVE("active"),
    INACTIVE("inactive");

    private String value;

    private Status(String value){
        this.value = value;
    }

    public String getStatus(){
        return value;
    }

}
