package com.java.cyberchamis.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;



@Entity
@Table(name="questions")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "question")
    private String question;

    @Column(name = "reponseCorrecte")
    private String reponseCorrecte;

    @Column(name = "point")
    private int point;  

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Indice indice;

    @OneToOne
    @JoinColumn(name = "etape")
    @JsonBackReference
    private Etape etape;
    
    //constructor
    
    public Question(String question, String reponseCorrecte, int point, Indice indice, Etape etape) {
        this.question = question;
        this.reponseCorrecte = reponseCorrecte;
        this.point = point;
        this.indice = indice;
        this.etape = etape;
    }

    public Question() {
    }

    //setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponseCorrecte() {
        return reponseCorrecte;
    }

    public void setReponseCorrecte(String reponseCorrecte) {
        this.reponseCorrecte = reponseCorrecte;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Indice getIndice() {
        return indice;
    }

    public void setIndice(Indice indice) {
        this.indice = indice;
        indice.setQuestion(this);
    }

    public Etape getEtape() {
        return etape;
    }

    public void setEtape(Etape etape) {
        this.etape = etape;
    }

    
}
