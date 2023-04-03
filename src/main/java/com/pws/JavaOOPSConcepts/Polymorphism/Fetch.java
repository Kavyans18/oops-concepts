package com.pws.JavaOOPSConcepts.Polymorphism;

import com.pws.JavaOOPSConcepts.entity.Admin;
import com.pws.JavaOOPSConcepts.exception.NoDataAvailableException;
import com.pws.JavaOOPSConcepts.inheretace.AdminRepository;
import com.pws.JavaOOPSConcepts.inheretace.MultiLevel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class Fetch {
    @Autowired
    AdminRepository repository;
    public List<Object> fetch() {
        List<Admin> admin = repository.findAll();
        if(admin == null) {
            throw new NoDataAvailableException("ADMIN LIST IS EMPTY");
        }
        return Collections.singletonList(admin);
    }
}
