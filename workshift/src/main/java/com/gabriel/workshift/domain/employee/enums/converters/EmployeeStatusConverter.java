package com.gabriel.workshift.domain.employee.enums.converters;

import com.gabriel.workshift.domain.employee.enums.EmployeeStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, String> {

    @Override
    public String convertToDatabaseColumn(EmployeeStatus employeeStatus) {
        if (employeeStatus == null) return null;
        return employeeStatus.getValue();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(String value) {

        if (value == null) return null;

        return Stream.of(EmployeeStatus.values())
                .filter(employeeStatus -> employeeStatus.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
