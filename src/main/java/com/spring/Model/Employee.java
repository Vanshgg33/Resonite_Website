package com.spring.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_ID;
    private String companyName;
    private String designation;
    private String experience;
    private String workDomain;

    @OneToOne
    @MapsId
    @JoinColumn(name = "UserId")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getWorkDomain() {
        return workDomain;
    }

    public void setWorkDomain(String workDomain) {
        this.workDomain = workDomain;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }
}
