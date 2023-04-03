package com.pws.JavaOOPSConcepts.Polymorphism;

import com.pws.JavaOOPSConcepts.entity.Admin;
import com.pws.JavaOOPSConcepts.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/override")
public class MethodOverriding{

    @Autowired
    Fetch fetch;

    @Autowired
    FetchEmployee fetchEmployee;

    @GetMapping("/adminFetch")
     public ResponseEntity<List<Object>> fetch(){
         List<Object> admin = fetch.fetch();
         return new ResponseEntity<>(admin, HttpStatus.OK);
      }

      @GetMapping("/employeeFetch")
      public ResponseEntity<List<Object>> fetchEmployee(){
        List<Object> employee = fetchEmployee.fetch();
        return new ResponseEntity<>(employee, HttpStatus.OK);
      }
}
