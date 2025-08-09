package com.gabriel.workshift.utils.enums.converters;

import com.gabriel.workshift.utils.enums.DayOfWeek;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DayOfWeekConverter implements AttributeConverter<Set<DayOfWeek>, String> {

    @Override
    public String convertToDatabaseColumn(Set<DayOfWeek> dayOfWeek) {

        return dayOfWeek == null ? null : dayOfWeek.stream()
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }

    @Override
    public Set<DayOfWeek> convertToEntityAttribute(String value) {

        return value == null ? null : Arrays.stream(value.split(","))
                .map(DayOfWeek::valueOf)
                .collect(Collectors.toSet());

    }
}
