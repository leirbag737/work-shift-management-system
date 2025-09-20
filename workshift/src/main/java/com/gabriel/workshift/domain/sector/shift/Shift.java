package com.gabriel.workshift.domain.sector.shift;

import com.gabriel.workshift.domain.sector.workingHours.WorkingHours;
import com.gabriel.workshift.utils.enums.Status;
import com.gabriel.workshift.utils.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.List;

@Entity
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    @NotNull
    private LocalTime shiftStart;

    @NotNull
    private LocalTime shiftEnd;

    @ManyToMany(mappedBy = "shifts")
    private List<WorkingHours> workingHours;

    public Shift() {
        super();
    }

    public Shift(LocalTime shiftStart, LocalTime shiftEnd) {
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
    }
}
