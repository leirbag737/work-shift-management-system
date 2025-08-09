package com.gabriel.workshift.domain.sector;

import com.gabriel.workshift.domain.jobTitle.JobTitle;
import com.gabriel.workshift.domain.sector.shift.Shift;
import com.gabriel.workshift.utils.enums.Status;
import com.gabriel.workshift.utils.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class RequiredStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    @NotNull
    private int minStaff;

    private int maxStaff;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    private Shift shift;

    @ManyToMany(mappedBy = "requiredStaffs")
    private List<SectorRequiredStaff> sectorRequiredStaffs;
}
