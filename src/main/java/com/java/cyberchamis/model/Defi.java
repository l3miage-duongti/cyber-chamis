package com.java.cyberchamis.model;

import javax.persistence.*;

import java.util.List;

@Entity
public class Defi {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String titre;

    @Column(name = "date_Creation")
    private String dateDeCreation;

    @ManyToOne
    @JoinColumn(name = "auteur")
    private Chami auteur;

    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Etape> etapes;

    @Column
    private String epilogue;

    //constructors
    public Defi(String titre, String dateDeCreation, Chami auteur, String description, List<Etape> etapes, String epilogue) {
        this.titre = titre;
        this.dateDeCreation = dateDeCreation;
        this.description = description;
        this.auteur = auteur;
        this.etapes = etapes;
        this.epilogue = epilogue;
    }

    //methodes
    public void addEtape (Etape e){
        this.etapes.add(e);
    }

    public void removeEtape (Etape e){
        this.etapes.remove(e);
    }

    //getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(String dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public Chami getAuteur() {
        return auteur;
    }

    public void setAuteur(Chami auteur) { this.auteur = auteur; }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    public String getEpilogue() {
        return epilogue;
    }

    public void setEpilogue(String epilogue) {
        this.epilogue = epilogue;
    }
    
    
}