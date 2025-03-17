package com.gabriel.workshift.domain.employee.enums.converters;

import com.gabriel.workshift.domain.employee.enums.ContractType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ContractTypeConverter implements AttributeConverter<ContractType, String> {

    @Override
    public String convertToDatabaseColumn(ContractType contractType) {
        if (contractType == null) return null;
        return contractType.getValue();
    }

    @Override
    public ContractType convertToEntityAttribute(String value) {

        if (value == null) return null;

        return Stream.of(ContractType.values())
                .filter(contractType -> contractType.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
