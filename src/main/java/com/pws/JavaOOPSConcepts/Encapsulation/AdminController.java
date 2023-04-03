package com.pws.JavaOOPSConcepts.Encapsulation;

import com.pws.JavaOOPSConcepts.entity.Admin;
import com.pws.JavaOOPSConcepts.exception.IdNotFoundException;
import com.pws.JavaOOPSConcepts.exception.NoDataAvailableException;
import com.pws.JavaOOPSConcepts.inheretace.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    AdminRepository repository;

    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        repository.save(admin);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PutMapping("/update/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin,@PathVariable int adminId) {
        Optional<Admin> optional = repository.findById(adminId);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("INVALID ADMIN ID");
        }
        Admin ad = optional.get();
        ad.setAdminName(admin.getAdminName());
        ad.setAdminEmail(admin.getAdminEmail());
        ad.setAdminPhoneNumber(admin.getAdminPhoneNumber());
        repository.save(ad);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    @GetMapping("/byId/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int adminId) {
        Optional<Admin> optional = repository.findById(adminId);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("INVALID ADMIN ID");
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admin = repository.findAll();
        if (admin == null) {
            throw new NoDataAvailableException("ADMIN LIST IS EMPTY");
        }
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{adminId}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable int adminId) {
        Optional<Admin> optional = repository.findById(adminId);
        if (optional.isEmpty()) {
            throw new IdNotFoundException("INVALID ADMIN ID");
        }
        repository.delete(optional.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
