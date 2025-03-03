package com.gabriel.workshift.domain.user.dto;

import com.gabriel.workshift.domain.user.enums.UserRole;

public record LoginResponseDTO(
        UserRole role,
        String token
) {
}
