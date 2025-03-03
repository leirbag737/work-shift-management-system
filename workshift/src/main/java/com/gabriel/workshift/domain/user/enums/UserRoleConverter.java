package com.gabriel.workshift.domain.user.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        if (userRole == null) return null;
        return userRole.getRole();
    }

    @Override
    public UserRole convertToEntityAttribute(String value) {

       if (value == null) return null;

       return Stream.of(UserRole.values())
               .filter(userRole -> userRole.getRole().equals(value))
               .findFirst()
               .orElseThrow(IllegalArgumentException::new);
    }
}
