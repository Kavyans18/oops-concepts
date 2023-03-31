package com.pws.JavaOOPSConcepts.Encapsulation;

import com.pws.JavaOOPSConcepts.entity.Employee;
import com.pws.JavaOOPSConcepts.exception.IdNotFoundException;
import com.pws.JavaOOPSConcepts.exception.NoDataAvailableException;
import com.pws.JavaOOPSConcepts.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        repository.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable int employeeId) {
        Optional<Employee> optional = repository.findById(employeeId);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid Employee ID");
        }
        Employee emp = optional.get();
        emp.setEmployeeName(employee.getEmployeeName());
        emp.setEmployeeEmail(employee.getEmployeeEmail());
        emp.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
        repository.save(emp);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("/byId/{employeeId}")
    public ResponseEntity<Employee> getUserById(@PathVariable int employeeId) {
        Optional<Employee> optional = repository.findById(employeeId);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid Employee ID");
        }
        Employee emp = optional.get();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll() {
       List<Employee> emp =  repository.findAll();
       if(emp == null) {
           throw new NoDataAvailableException("EMPLOYEE LIST IS EMPTY");
       }
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int employeeId) {
        Optional<Employee> optional = repository.findById(employeeId);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("Invalid Employee ID");
        }
        repository.delete(optional.get());
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

}
