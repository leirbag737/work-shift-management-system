package com.gabriel.workshift.domain.sector.workingHours.dto.mapper;

import com.gabriel.workshift.domain.sector.workingHours.WorkingHours;
import com.gabriel.workshift.domain.sector.workingHours.dto.WorkingHoursRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class WorkingHoursMapper {

    public WorkingHours workingHoursRequestDtoToWorkingHoursEntity(WorkingHoursRequestDTO dto) {

        return new WorkingHours(
                dto.description(),
                dto.daysOfWeek(),
                dto.standardTime(),
                dto.openingTime(),
                dto.closingTime(),
                dto.effectiveStartDate(),
                dto.effectiveEndDate(),
                dto.numberShifts()
        );
    }
}
