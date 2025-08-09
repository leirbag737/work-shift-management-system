package com.gabriel.workshift.utils.enums;

public enum DayOfWeek {

    SUNDAY("sunday"),
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday");

    private String value;

    private DayOfWeek(String value){
        this.value = value;
    }

    public String getDayOfWeek(){
        return value;
    }

}
