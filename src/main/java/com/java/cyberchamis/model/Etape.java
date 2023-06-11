package com.java.cyberchamis.model;

import javax.persistence.*;

import java.util.Set;


@Entity
public class Etape {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String instruction;

    @ManyToOne
    private Arret arret;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions;

    //constructors
    public Etape(String instruction, Arret arret, Set<Question> questions) {
        this.instruction = instruction;
        this.arret = arret;
        this.questions = questions;
    }

    public Etape(){}

    //setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Arret getArret() { return arret; }

    public void setArret(Arret arret) { this.arret = arret; }

    public Set<Question> getQuestions() { return questions; }

    public void setQuestions(Set<Question> questions) { this.questions = questions; }
}

