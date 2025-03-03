package com.gabriel.workshift.domain.user.dto;

public record AuthenticationDTO(
        String login,
        String password
) {
}
