package com.pws.JavaOOPSConcepts.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private int employeeId;
    @Column(name = "employeeName", nullable = false)
    private String employeeName;
    @Column(name = "employeeEmail", nullable = false)
    private String employeeEmail;
    @Column(name = "employeePhoneNumber", nullable = false)
    private long employeePhoneNumber;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public long getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(long employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }
}
