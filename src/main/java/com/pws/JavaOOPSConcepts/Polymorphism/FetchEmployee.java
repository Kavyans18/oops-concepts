package com.pws.JavaOOPSConcepts.Polymorphism;

import com.pws.JavaOOPSConcepts.entity.Employee;
import com.pws.JavaOOPSConcepts.exception.NoDataAvailableException;
import com.pws.JavaOOPSConcepts.inheretace.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FetchEmployee extends Fetch{
    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Object> fetch() {
        List<Employee> emp = repository.findAll();
        if(emp == null) {
            throw new NoDataAvailableException("EMPLOYEE LIST IS EMPTY");
        }
        return Collections.singletonList(emp);
    }
}
