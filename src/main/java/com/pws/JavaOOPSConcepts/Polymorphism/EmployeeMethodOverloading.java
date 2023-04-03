package com.pws.JavaOOPSConcepts.Polymorphism;

import com.pws.JavaOOPSConcepts.entity.Employee;
import com.pws.JavaOOPSConcepts.exception.EmailNotFoundException;
import com.pws.JavaOOPSConcepts.exception.PhoneNumberNotFoundException;
import com.pws.JavaOOPSConcepts.inheretace.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/methods")
public class EmployeeMethodOverloading {
    @Autowired
    EmployeeRepository repository;

    @GetMapping("/email/{employeeEmail}")
    public ResponseEntity<Employee> display(@PathVariable String employeeEmail) {
        Optional<Employee> optional = repository.byEmail(employeeEmail);
        if(optional.isEmpty()) {
            throw new EmailNotFoundException("INVALID EMAIL ID");
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @GetMapping("/phone/{employeePhoneNumber}")
    public ResponseEntity<Employee> display(@PathVariable long employeePhoneNumber) {
        Optional<Employee> optional = repository.byPhoneNumber(employeePhoneNumber);
        if(optional.isEmpty()) {
            throw new PhoneNumberNotFoundException("INVALID PHONE NUMBER");
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }
}
