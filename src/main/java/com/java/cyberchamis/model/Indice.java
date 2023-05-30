package com.java.cyberchamis.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;



@Entity
@Table(name="indices")
public class Indice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "pointReduit")
    private int pointReduit;

    @OneToOne
    @JoinColumn(name="question")
    @JsonBackReference
    private Question question;

    //constructors
    public Indice() {
    }
    
    public Indice(String description, int pointReduit, Question question) {
        this.description = description;
        this.pointReduit = pointReduit;
        this.question = question;
    }


    //setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPointReduit() {
        return pointReduit;
    }

    public void setPointReduit(int pointReduit) {
        this.pointReduit = pointReduit;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    
}
