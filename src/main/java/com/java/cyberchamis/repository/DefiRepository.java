package com.java.cyberchamis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.java.cyberchamis.model.Chami;
import com.java.cyberchamis.model.Defi;

public interface DefiRepository extends JpaRepository<Defi, Integer> {
    public List<Defi> findAllByAuteur (Chami c);
}