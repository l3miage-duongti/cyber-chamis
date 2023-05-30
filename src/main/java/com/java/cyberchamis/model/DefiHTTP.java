package com.java.cyberchamis.model;

import java.sql.Timestamp;

public class DefiHTTP {
    
    private String id;
    private String titre;
    private Timestamp dateDeCreation;
    private String auteur;
    private String description;
    

    public DefiHTTP(String id, String titre, Timestamp date, String nom, String desc){
        this.id = id;
        this.titre = titre;
        this.dateDeCreation = date;
        this.auteur = nom;
        this.description = desc;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public Timestamp getDateDeCreation() {
        return dateDeCreation;
    }
    public void setDateDeCreation(Timestamp dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    
}
