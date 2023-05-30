package com.java.cyberchamis.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "defis")
public class Defi {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "dateDeCreation")
    private String dateDeCreation;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "arret")
    @JsonBackReference(value = "defis-arret")
    private Arret arret;

    @OneToMany(mappedBy = "defi", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Etape> etapes;

    @ManyToOne
    @JoinColumn(name = "auteur")
    @JsonBackReference
    private Chami auteur;

    @Column(name = "epilogue")
    private String epilogue;

    //constructors
    public Defi() {
    }

    public Defi(String titre, String dateDeCreation, String description, Arret arret, List<Etape> etapes,
        Chami auteur, String epilogue) {
        this.titre = titre;
        this.dateDeCreation = dateDeCreation;
        this.description = description;
        this.arret = arret;
        this.etapes = etapes;
        this.auteur = auteur;
        this.epilogue = epilogue;
    }

    //methodes
    public void addEtape (Etape e){
        this.etapes.add(e);
        e.setDefi(this);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Arret getArret() {
        return arret;
    }

    public void setArret(Arret arret) {
        this.arret = arret;
        arret.getDefis().add(this);
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    public Chami getAuteur() {
        return auteur;
    }

    public void setAuteur(Chami auteur) {
        this.auteur = auteur;
        auteur.getDefis().add(this);
    }

    public String getEpilogue() {
        return epilogue;
    }

    public void setEpilogue(String epilogue) {
        this.epilogue = epilogue;
    }

    //setters et getters
    
    
}