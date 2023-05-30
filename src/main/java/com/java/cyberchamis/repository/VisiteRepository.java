package com.java.cyberchamis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.java.cyberchamis.model.Chami;
import com.java.cyberchamis.model.Defi;
import com.java.cyberchamis.model.Visite;

public interface VisiteRepository extends JpaRepository<Visite, Integer> {
    
    //Renvoyer tous les Visites d'un Chami
    public List<Visite> findAllByChami (Chami c);
    //Renvoyer tous les Visites d'un Defi
    public List<Visite> findAllByDefi (Defi d);
}
