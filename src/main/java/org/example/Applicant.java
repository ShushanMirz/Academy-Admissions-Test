package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Applicant {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private boolean isWarVeteran;
    private boolean isLessThan16;
    private String courseId;

    public Applicant(String firstName, String lastName, String middleName, String email, String phone, boolean isWarVeteran, boolean isLessThan16, String courseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phone = phone;
        this.isWarVeteran = isWarVeteran;
        this.isLessThan16 = isLessThan16;
        this.courseId = courseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    @JsonProperty(value="isWarVeteran")
    public boolean isWarVeteran() {
        return isWarVeteran;
    }

    public void setWarVeteran(boolean isWarVeteran) {
        this.isWarVeteran = isWarVeteran;
    }

    @JsonProperty(value="isLessThan16")
    public boolean isLessThan16() {
        return isLessThan16;
    }

    public void setLessThan16(boolean isLessThan16) {
        this.isLessThan16 = isLessThan16;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isWarVeteran=" + isWarVeteran +
                ", isLessThan16=" + isLessThan16 +
                ", courseId='" + courseId + '\'' +
                '}';


    }


}
