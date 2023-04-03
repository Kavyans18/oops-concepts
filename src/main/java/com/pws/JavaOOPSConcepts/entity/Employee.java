package com.pws.JavaOOPSConcepts.entity;

import lombok.Data;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "Employee")
@Validated
public class Employee {
    @Id
    private int employeeId;
    @Column(name = "employeeName", nullable = false)
    private String employeeName;
    @Column(name = "employeeEmail", nullable = false)
    @Email(message = "ENTER VALID EMAIL")
    private String employeeEmail;
    @Column(name = "employeePhoneNumber", nullable = false, length = 13)
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
