package com.java.cyberchamis.model;

import javax.persistence.*;

@Entity
@Table(name = "visites")
public class Visite {
    
    //attributs
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "dateDeVisite")
    private String dateDeVisite;

    @Column(name = "statut")
    private String statut;

    @Column(name = "temps")
    private Float temps;

    //le point gagne
    @Column(name = "score")
    private int score;

    @Column(name = "commentaires")
    private String commentaires;

    @ManyToOne
    @JoinColumn(name = "defi")
    private Defi defi;

    @ManyToOne
    @JoinColumn(name = "chami")
    private Chami chami;

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
