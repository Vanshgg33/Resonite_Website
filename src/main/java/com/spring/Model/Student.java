package com.spring.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity

@Table(name = "Student_Detail")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;

    private String institution;
    private String Course;
    private String graduationYear;

    @OneToOne
   @MapsId
    @JoinColumn(name="user_id")
    private User user;

    public int getStudent_Id() {
        return userID;
    }

    public void setStudent_Id(int student_Id) {
        userID = student_Id;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}