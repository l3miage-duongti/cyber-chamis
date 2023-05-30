package com.java.cyberchamis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.java.cyberchamis.model.Etape;
import com.java.cyberchamis.model.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Integer> {
    //Renvoyer tous les Materiels d'une Etape
    public List<Materiel> findAllByEtape (Etape e);
}
