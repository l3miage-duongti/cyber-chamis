package com.java.cyberchamis.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

//import java.lang.annotation.Inherited;
import java.util.List;

@Entity
//@Table(name = "chamis")
public class Chami {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Defi> defis;
    
    //setters et getters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Defi> getDefis() {
        return defis;
    }

    public void setDefis(List<Defi> defis) {
        this.defis = defis;
    }

    
}
