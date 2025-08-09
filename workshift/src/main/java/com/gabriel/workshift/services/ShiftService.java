package com.gabriel.workshift.services;

import com.gabriel.workshift.domain.sector.shift.Shift;
import com.gabriel.workshift.domain.sector.shift.dto.ShiftRequestDTO;
import com.gabriel.workshift.domain.sector.shift.dto.mapper.ShiftMapper;
import com.gabriel.workshift.repositories.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private ShiftMapper shiftMapper;

    public Shift create(ShiftRequestDTO data) {
        return shiftRepository.save(shiftMapper.shiftRequestDtoToShiftEntity(data));
    }

    public List<Shift> create(List<ShiftRequestDTO> data) {
        return data.stream()
                .map(
                        s -> {
                            return shiftRepository.save(shiftMapper.shiftRequestDtoToShiftEntity(s));
                        }
                ).collect(Collectors.toList());
    }
}
