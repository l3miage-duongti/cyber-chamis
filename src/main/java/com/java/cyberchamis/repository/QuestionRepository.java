package com.java.cyberchamis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.cyberchamis.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {}