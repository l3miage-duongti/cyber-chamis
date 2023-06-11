package com.java.cyberchamis.repository;

import com.java.cyberchamis.model.Chami;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChamiRepository extends JpaRepository<Chami, String> {
    boolean existsByEmail(String email);
    Chami findByEmail(String email);
}
