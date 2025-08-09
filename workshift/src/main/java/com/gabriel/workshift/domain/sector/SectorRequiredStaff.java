package com.gabriel.workshift.domain.sector;

import com.gabriel.workshift.utils.enums.Status;
import com.gabriel.workshift.utils.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SectorRequiredStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToMany
    @JoinTable(
            name = "sector_required_staff_mapping",
            joinColumns = @JoinColumn(name = "sector_required_staff_id"),
            inverseJoinColumns = @JoinColumn(name = "required_staff_id")
    )
    private List<RequiredStaff> requiredStaffs = new ArrayList<>();
}
