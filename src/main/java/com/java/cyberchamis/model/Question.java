package com.java.cyberchamis.model;

import javax.persistence.*;


@Entity
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String question;

    @Column(name = "reponse_correcte")
    private String reponseCorrecte;

    @Column
    private int point;

    @Column
    private String indice;

    @Column(name = "cout_indice")
    private int coutIndice;

    public Question(String question, String reponseCorrecte, int point, String indice, int coutIndice) {
        this.question = question;
        this.reponseCorrecte = reponseCorrecte;
        this.point = point;
        this.indice = indice;
        this.coutIndice = coutIndice;
    }

    public Question(){}

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

    public String getIndice() { return indice; }

    public void setIndice(String indice) { this.indice = indice; }

    public int getCoutIndice() { return coutIndice; }

    public void setCoutIndice(int coutIndice) {
        this.coutIndice = coutIndice;
    }
}
