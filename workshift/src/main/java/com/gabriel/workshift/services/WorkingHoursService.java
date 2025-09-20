package com.gabriel.workshift.services;

import com.gabriel.workshift.domain.sector.workingHours.WorkingHours;
import com.gabriel.workshift.domain.sector.workingHours.dto.WorkingHoursRequestDTO;
import com.gabriel.workshift.domain.sector.workingHours.dto.mapper.WorkingHoursMapper;
import com.gabriel.workshift.repositories.WorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkingHoursService {

    @Autowired
    private WorkingHoursRepository workingHoursRepository;

    @Autowired
    private WorkingHoursMapper workingHoursMapper;

    @Autowired
    private ShiftService shiftService;


    public WorkingHours create(WorkingHoursRequestDTO data) {

        WorkingHours newWorkingHours = workingHoursMapper.workingHoursRequestDtoToWorkingHoursEntity(data);
        newWorkingHours.setShifts(shiftService.findOrCreateShifts(data.shifts()));

        return workingHoursRepository.save(newWorkingHours);
    }
}
