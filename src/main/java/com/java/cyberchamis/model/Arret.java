package com.java.cyberchamis.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import java.util.List;


@Entity
@Table(name = "arrets")
public class Arret {

    @Id
    @Column(name = "codeTAG", unique = true)
    private String codeTAG;

    @Column(name = "arret", unique = true)
    private String arret;

    @Column(name = "lienStreetMap", unique = true)
    private String lienStreetMap;

    @OneToMany(mappedBy = "arret", cascade=CascadeType.ALL)
    @JsonManagedReference(value="defis-arret")
    private List<Defi> defis;

    public String getCodeTAG() {
        return codeTAG;
    }

    public void setCodeTAG(String codeTAG) {
        this.codeTAG = codeTAG;
    }

    public String getArret() {
        return arret;
    }

    public void setArret(String arret) {
        this.arret = arret;
    }

    public String getLienStreetMap() {
        return lienStreetMap;
    }

    public void setLienStreetMap(String lienStreetMap) {
        this.lienStreetMap = lienStreetMap;
    }

    public List<Defi> getDefis() {
        return defis;
    }

    public void setDefis(List<Defi> defis) {
        this.defis = defis;
    }

    
}
