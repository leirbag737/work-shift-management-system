package com.gabriel.workshift.domain.sector.workingHours.dto;

import com.gabriel.workshift.domain.sector.shift.dto.ShiftRequestDTO;
import com.gabriel.workshift.utils.enums.DayOfWeek;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public record WorkingHoursRequestDTO(

        String description,

        Set<DayOfWeek> daysOfWeek,

        boolean standardTime,

        LocalTime openingTime,

        LocalTime closingTime,

        LocalDateTime effectiveStartDate,

        LocalDateTime effectiveEndDate,

        int numberShifts,

        List<ShiftRequestDTO> shifts
) {
}
