package com.java.cyberchamis.repository;
import com.java.cyberchamis.model.Arret;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArretRepository extends JpaRepository<Arret, String> {
    public boolean existsByCodeTAG(String code);
    public boolean existsByLienStreetMap(String lien);
}