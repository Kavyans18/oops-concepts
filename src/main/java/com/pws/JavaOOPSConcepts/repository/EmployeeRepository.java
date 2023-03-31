package com.pws.JavaOOPSConcepts.repository;

import com.pws.JavaOOPSConcepts.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.employeeEmail = :employeeEmail")
    Optional<Employee> byEmail(String employeeEmail);

    @Query("select e from Employee e where e.employeePhoneNumber = :employeePhoneNumber")
    Optional<Employee> byPhoneNumber(long employeePhoneNumber);

}
