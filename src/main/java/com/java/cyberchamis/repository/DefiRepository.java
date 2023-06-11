package com.java.cyberchamis.repository;

import com.java.cyberchamis.model.Arret;
import com.java.cyberchamis.model.Chami;
import com.java.cyberchamis.model.Defi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DefiRepository extends JpaRepository<Defi, Integer> {
    List<Defi> findAllByAuteur (Chami c);

    List<Defi> findAllByDepart(Arret depart);
}
