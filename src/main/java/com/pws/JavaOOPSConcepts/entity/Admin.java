package com.pws.JavaOOPSConcepts.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Data
@Table(name = "Admin")
public class Admin {
    @Id
    @Column(name = "admin_id")
    private int adminId;
    @Column(name = "admin_name", nullable = false)
    private String adminName;
    @Column(name = "admin_email", nullable = false)
    @Email(message = "INVALID EMAIL ADDRESS" )
    private String adminEmail;
    @Column(name = "admin_phone_number", nullable = false)
    private long adminPhoneNumber;
}
