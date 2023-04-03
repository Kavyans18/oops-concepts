package com.pws.JavaOOPSConcepts.inheretace;

import com.pws.JavaOOPSConcepts.entity.Admin;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Primary
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query("select a from Admin a where a.adminEmail = :adminEmail")
    Optional<Admin> getAdminByEmail(String adminEmail);
}
