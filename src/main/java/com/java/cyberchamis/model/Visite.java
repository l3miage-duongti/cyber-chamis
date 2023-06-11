package com.java.cyberchamis.model;

import javax.persistence.*;

@Entity
public class Visite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date")
    private String dateDeVisite;

    @Column
    private String statut;

    @Column
    private Float temps;

    //le point gagne
    @Column
    private int score;

    @Column
    private String commentaires;

    @ManyToOne
    private Defi defi;

    @ManyToOne
    @JoinColumn(name = "chami")
    private Chami chami;

    public Visite(String dateDeVisite, String statut, Float temps, int score, String commentaires, Defi defi, Chami chami){
        this.dateDeVisite = dateDeVisite;
        this.statut = statut;
        this.temps = temps;
        this.score = score;
        this.commentaires = commentaires;
        this.defi = defi;
        this.chami = chami;
    }

    public Visite(){}

    //getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDeVisite() {
        return dateDeVisite;
    }

    public void setDateDeVisite(String dateDeVisite) {
        this.dateDeVisite = dateDeVisite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Float getTemps() {
        return temps;
    }

    public void setTemps(Float temps) {
        this.temps = temps;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public Defi getDefi() {
        return defi;
    }

    public void setDefi(Defi defi) {
        this.defi = defi;
    }

    public Chami getChami() {
        return chami;
    }

    public void setChami(Chami chami) {
        this.chami = chami;
    }
}
