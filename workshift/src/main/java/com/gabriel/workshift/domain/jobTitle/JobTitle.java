package com.gabriel.workshift.domain.jobTitle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.workshift.domain.employee.Employee;
import com.gabriel.workshift.domain.documents.DocumentType;
import com.gabriel.workshift.utils.enums.Status;
import com.gabriel.workshift.utils.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Table(name = "job_title")
@SQLDelete(sql = "UPDATE job_title SET job_title_status = 'inactive' WHERE id=?")
@SQLRestriction("job_title_status <> 'inactive'")
public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Convert(converter = StatusConverter.class)
    private Status jobTitleStatus = Status.ACTIVE;

    @NotNull(message = "Job title cannot be empty.")
    @NotBlank(message = "Job title cannot be empty.")
    private String name;

    @OneToMany(mappedBy = "jobTitle", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employeeList;

    @ManyToMany
    @JoinTable(
            name = "job_title__document_type",
            joinColumns = @JoinColumn(name = "job_title_id"),
            inverseJoinColumns = @JoinColumn(name = "document_type_id")
    )
    private List<DocumentType> documentTypes;


    public JobTitle() {
    }

    public JobTitle(String name) {
        this.name = name;
    }

    public String getId() {
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
