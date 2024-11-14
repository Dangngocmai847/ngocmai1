package com.example.SBles1;

import java.time.LocalDate;

public class Exercise4 {
    private int id;
    private double salary;
    private String fullName;
    private String gender;
    private LocalDate birthDay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Exercise4(int id, LocalDate birthDay, String gender, double salary, String fullName) {
        this.id = id;
        this.birthDay = birthDay;
        this.gender = gender;
        this.salary = salary;
        this.fullName = fullName;
    }

    public Exercise4() {
    }
}
