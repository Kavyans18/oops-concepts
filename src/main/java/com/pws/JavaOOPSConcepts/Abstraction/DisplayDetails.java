package com.pws.JavaOOPSConcepts.Abstraction;

import com.pws.JavaOOPSConcepts.Encapsulation.EmployeeController;
import com.pws.JavaOOPSConcepts.entity.Employee;
import com.pws.JavaOOPSConcepts.exception.NoDataAvailableException;
import com.pws.JavaOOPSConcepts.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DisplayDetails implements Display{

    @Autowired
    EmployeeRepository repository;

    @Override
    @GetMapping("/display")
    public ResponseEntity<List<Employee>> display() {
        List<Employee> emp =  repository.findAll();
        if(emp == null) {
            throw new NoDataAvailableException("EMPLOYEE LIST IS EMPTY");
        }
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }
}