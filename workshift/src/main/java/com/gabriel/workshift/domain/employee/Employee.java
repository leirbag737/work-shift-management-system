package com.gabriel.workshift.domain.employee;

import com.gabriel.workshift.domain.employee.enums.ContractType;
import com.gabriel.workshift.domain.employee.enums.EmployeeStatus;
import com.gabriel.workshift.domain.employee.enums.converters.ContractTypeConverter;
import com.gabriel.workshift.domain.employee.enums.converters.EmployeeStatusConverter;
import com.gabriel.workshift.domain.documents.DocumentType;
import com.gabriel.workshift.domain.documents.ProfessionalDocument;
import com.gabriel.workshift.domain.employee.shiftType.ShiftType;
import com.gabriel.workshift.domain.employee.statusHistory.EmployeeStatusHistory;
import com.gabriel.workshift.domain.jobTitle.JobTitle;
import com.gabriel.workshift.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Convert(converter = EmployeeStatusConverter.class)
    private EmployeeStatus employeeStatus = EmployeeStatus.ACTIVE;

    @NotNull
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType personalDocumentType;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String personalDocument;

    @Convert(converter = ContractTypeConverter.class)
    private ContractType contractType;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String phoneNumber;

    @OneToOne(mappedBy = "employee")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "shift_type_id")
    private ShiftType shiftType;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @OneToMany(mappedBy = "employee")
    private Set<ProfessionalDocument> professionalDocuments;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeStatusHistory> employeeStatusHistories = new HashSet<>();

    public Employee() {
    }

    public Employee(String name, DocumentType personalDocumentType,
                    String personalDocument, ContractType contractType,
                    String email, String phoneNumber, ShiftType shiftType,
                    JobTitle jobTitle) {
        this.name = name;
        this.personalDocumentType = personalDocumentType;
        this.personalDocument = personalDocument;
        this.contractType = contractType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.shiftType = shiftType;
        this.jobTitle = jobTitle;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentType getPersonalDocumentType() {
        return personalDocumentType;
    }

    public void setPersonalDocumentType(DocumentType personalDocumentType) {
        this.personalDocumentType = personalDocumentType;
    }

    public String getPersonalDocument() {
        return personalDocument;
    }

    public void setPersonalDocument(String personalDocument) {
        this.personalDocument = personalDocument;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Set<ProfessionalDocument> getProfessionalDocuments() {
        return professionalDocuments;
    }

    public void setProfessionalDocuments(Set<ProfessionalDocument> professionalDocuments) {
        this.professionalDocuments = professionalDocuments;
    }

    public Set<EmployeeStatusHistory> getEmployeeStatusHistories() {
        return employeeStatusHistories;
    }

    public void setEmployeeStatusHistories(Set<EmployeeStatusHistory> employeeStatusHistories) {
        this.employeeStatusHistories = employeeStatusHistories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
