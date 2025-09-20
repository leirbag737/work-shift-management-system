package com.gabriel.workshift.services;

import com.gabriel.workshift.domain.sector.shift.Shift;
import com.gabriel.workshift.domain.sector.shift.dto.ShiftRequestDTO;
import com.gabriel.workshift.domain.sector.shift.dto.mapper.ShiftMapper;
import com.gabriel.workshift.repositories.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private ShiftMapper shiftMapper;


    public List<Shift> findOrCreateShifts(List<ShiftRequestDTO> shiftRequestDTOS) {

        List<Shift> shifts = new ArrayList<>();

        if (shiftRequestDTOS == null || shiftRequestDTOS.isEmpty()) {
            return shifts;
        }

        shiftRequestDTOS.forEach(shiftRequestDTO -> {

            Shift shift = shiftRepository.findByShiftStartAndShiftEnd(shiftRequestDTO.shiftStart(), shiftRequestDTO.shiftEnd())
                    .orElseGet(() -> create(shiftRequestDTO));

            shifts.add(shift);
        });

        return shifts;
    }


    public Shift create(ShiftRequestDTO data) {
        return shiftRepository.save(shiftMapper.shiftRequestDtoToShiftEntity(data));
    }

}
