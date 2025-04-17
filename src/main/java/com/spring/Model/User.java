package com.spring.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity

@Table(name = "User_Info")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int user_id;

    private String name;
    private String email;
    private String phone;
    private int age;
    private String address;
    private String city;
    private String state;
    private String pincode;
    private String highestEdu;
    private String currentStatus;
    private String courseInterest;

    // Correct OneToOne mappings
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = true)
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = true)
    private Employee employee;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Course_Fees_INFO courseFeesInfo;





    public String getCourseInterest() {
        return courseInterest;
    }

    public void setCourseInterest(String courseInterest) {
        this.courseInterest = courseInterest;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getHighestEdu() {
        return highestEdu;
    }

    public void setHighestEdu(String highestEdu) {
        this.highestEdu = highestEdu;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
