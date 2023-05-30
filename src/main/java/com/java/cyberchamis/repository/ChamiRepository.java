package com.java.cyberchamis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.cyberchamis.model.Chami;

public interface ChamiRepository extends JpaRepository<Chami, String> {
    public boolean existsByEmail(String email);
    public Chami findByEmail(String email);
}