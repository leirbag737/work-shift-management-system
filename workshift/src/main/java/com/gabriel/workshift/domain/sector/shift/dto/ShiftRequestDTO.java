package com.gabriel.workshift.domain.sector.shift.dto;

import java.time.LocalTime;

public record ShiftRequestDTO(
        LocalTime shiftStart,
        LocalTime shiftEnd
) {
}
