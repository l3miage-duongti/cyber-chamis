package com.java.cyberchamis.repository;

import com.java.cyberchamis.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {}