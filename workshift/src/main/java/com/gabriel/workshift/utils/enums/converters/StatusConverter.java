package com.gabriel.workshift.utils.enums.converters;

import com.gabriel.workshift.utils.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {


    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) return null;
        return status.getStatus();
    }

    @Override
    public Status convertToEntityAttribute(String value) {

        if (value == null) return null;

        return Stream.of(Status.values())
                .filter(status -> status.getStatus().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
