package com.pws.JavaOOPSConcepts.Abstraction;

import com.pws.JavaOOPSConcepts.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Display {

     ResponseEntity<List<Employee>> display();
}
