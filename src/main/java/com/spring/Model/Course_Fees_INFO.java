package com.spring.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.security.PrivilegedAction;

@Entity
@Data
@Table(name = "Course_Fees")
@Inheritance(strategy = InheritanceType.JOINED)
public class Course_Fees_INFO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int FeeId;
    private String name;
    private String CourseName;
    private Double Total_Fees;
    private String DatePaid;
    private Double FeePaid;
    private Double RemainingFees;


    @OneToOne
    private User user;

    public int getFeeId() {
        return FeeId;
    }

    public void setFeeId(int feeId) {
        FeeId = feeId;
    }

    public Double getTotal_Fees() {
        return Total_Fees;
    }

    public void setTotal_Fees(Double total_Fees) {
        Total_Fees = total_Fees;
    }

    public String getDatePaid() {
        return DatePaid;
    }

    public void setDatePaid(String datePaid) {
        DatePaid = datePaid;
    }

    public Double getFeePaid() {
        return FeePaid;
    }

    public void setFeePaid(Double feePaid) {
        FeePaid = feePaid;
    }

    public Double getRemainingFees() {
        return RemainingFees;
    }

    public void setRemainingFees(Double remainingFees) {
        RemainingFees = remainingFees;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
}
