package com.gabriel.workshift.domain.user.dto;

import com.gabriel.workshift.domain.user.enums.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role) {
}
