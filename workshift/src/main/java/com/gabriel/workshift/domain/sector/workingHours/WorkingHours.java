package com.gabriel.workshift.domain.sector.workingHours;

import com.gabriel.workshift.domain.sector.Sector;
import com.gabriel.workshift.domain.sector.shift.Shift;
import com.gabriel.workshift.utils.enums.DayOfWeek;
import com.gabriel.workshift.utils.enums.Status;
import com.gabriel.workshift.utils.enums.converters.DayOfWeekConverter;
import com.gabriel.workshift.utils.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class WorkingHours {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    private String description;

    @Convert(converter = DayOfWeekConverter.class)
    private Set<DayOfWeek> daysOfWeek;

    @NotNull
    private boolean standardTime;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private LocalDateTime effectiveStartDate;

    private LocalDateTime effectiveEndDate;

    @NotNull
    private int numberShifts;

    @ManyToMany
    @JoinTable(
            name = "working_hours_shift_mapping",
            joinColumns = @JoinColumn(name = "working_hours_id"),
            inverseJoinColumns = @JoinColumn(name = "shift_id")
    )
    private List<Shift> shifts = new ArrayList<>();

    @OneToMany(mappedBy = "workingHours")
    private List<Sector> sectors;

    public WorkingHours(String description, Set<DayOfWeek> daysOfWeek, boolean standardTime,
                        LocalTime openingTime, LocalTime closingTime,
                        LocalDateTime effectiveStartDate, LocalDateTime effectiveEndDate,
                        int numberShifts) {
        this.description = description;
        this.daysOfWeek = daysOfWeek;
        this.standardTime = standardTime;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.effectiveStartDate = effectiveStartDate;
        this.effectiveEndDate = effectiveEndDate;
        this.numberShifts = numberShifts;
    }


    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
}
