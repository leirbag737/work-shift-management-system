package com.gabriel.workshift.domain.sector;

import com.gabriel.workshift.domain.sector.workingHours.WorkingHours;
import com.gabriel.workshift.utils.enums.Status;
import com.gabriel.workshift.utils.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Boolean continuosOperation;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "working_hours_id")
    private WorkingHours workingHours;

    @ManyToOne
    @JoinColumn(name = "sector_required_staff_id")
    private SectorRequiredStaff sectorRequiredStaff;
}
