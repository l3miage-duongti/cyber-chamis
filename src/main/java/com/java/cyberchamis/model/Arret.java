package com.java.cyberchamis.model;

import javax.persistence.*;

@Entity
public class Arret {

    @Id
    @Column(name = "codeTAG")
    private String codeTAG;

    @Column(name = "arret", unique = true)
    private String arret;

    @Column(name = "lienStreetMap", unique = true)
    private String lienStreetMap;

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

}
