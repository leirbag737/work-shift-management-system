package com.gabriel.workshift.domain.documents;

import com.gabriel.workshift.domain.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProfessionalDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @NotNull
    @NotBlank
    private String documentNumber;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String observation;

    public ProfessionalDocument() {
    }

    public ProfessionalDocument(DocumentType documentType, String documentNumber, Employee employee) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.employee = employee;
    }


    public String getId() {
        return id;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
