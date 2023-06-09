package com.java.cyberchamis.model;

import javax.persistence.*;

@Entity
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "lien")
    private String lien;

    @ManyToOne
    @JoinColumn(name = "etape")
    private Etape etape;

    public Materiel(String description, String lien, Etape etape){
        this.description = description;
        this.lien = lien;
        this.etape = etape;
    }

    public Materiel(){}

    //setters et getters
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

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Etape getEtape() {
        return etape;
    }

    public void setEtape(Etape etape) {
        this.etape = etape;
    }

}
