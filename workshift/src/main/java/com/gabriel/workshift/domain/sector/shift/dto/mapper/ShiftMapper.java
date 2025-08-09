package com.gabriel.workshift.domain.sector.shift.dto.mapper;

import com.gabriel.workshift.domain.sector.shift.Shift;
import com.gabriel.workshift.domain.sector.shift.dto.ShiftRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ShiftMapper {

    public Shift shiftRequestDtoToShiftEntity(ShiftRequestDTO dto) {
        return new Shift(dto.shiftStart(), dto.shiftEnd());
    }
}
