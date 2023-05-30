package com.java.cyberchamis.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name="etapes")
public class Etape {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="instruction")
    private String instruction;

    @OneToOne(mappedBy = "etape", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Question question;

    @ManyToOne
    @JoinColumn(name="defi")
    @JsonBackReference
    private Defi defi;

    //constructors
    public Etape(String instruction, Question question, Defi defi) {
        this.instruction = instruction;
        this.question = question;
        this.defi = defi;
    }

    public Etape() {
    }

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question q) {
        this.question = q;
        q.setEtape(this);
    }

    public Defi getDefi() {
        return defi;
    }

    public void setDefi(Defi defi) {
        this.defi = defi;
    }

    
}

