package com.java.cyberchamis.repository;

import com.java.cyberchamis.model.Chami;
import com.java.cyberchamis.model.Defi;
import com.java.cyberchamis.model.Visite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisiteRepository extends JpaRepository<Visite, Integer> {

    //Renvoyer tous les Visites d'un Chami
    List<Visite> findAllByChami (Chami c);

    //Renvoyer tous les Visites d'un Defi
    List<Visite> findAllByDefi (Defi d);
}
