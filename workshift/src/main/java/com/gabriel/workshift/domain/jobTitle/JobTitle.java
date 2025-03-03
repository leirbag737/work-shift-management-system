package com.gabriel.workshift.domain.jobTitle;

import com.gabriel.workshift.utils.enums.Status;
import com.gabriel.workshift.utils.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "job_title")
@SQLDelete(sql = "UPDATE job_title SET job_title_status = 'inactive' WHERE id=?")
@SQLRestriction("job_title_status <> 'inactive'")
public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Convert(converter = StatusConverter.class)
    private Status jobTitleStatus = Status.ACTIVE;

    @NotNull
    @NotBlank
    private String name;

    public JobTitle() {
    }

    public JobTitle(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Status getJobTitleStatus() {
        return jobTitleStatus;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
