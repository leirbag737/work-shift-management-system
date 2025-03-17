package com.gabriel.workshift.domain.documents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.workshift.domain.jobTitle.JobTitle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "documentTypes")
    @JsonIgnore
    private List<JobTitle> jobTitles;


    public DocumentType() {
    }

    public DocumentType(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JobTitle> getJobTitles() {
        return jobTitles;
    }

    public void setJobTitles(List<JobTitle> jobTitles) {
        this.jobTitles = jobTitles;
    }
}
