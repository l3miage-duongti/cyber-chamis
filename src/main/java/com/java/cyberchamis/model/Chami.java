package com.java.cyberchamis.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

//import java.lang.annotation.Inherited;
import java.util.List;

@Entity
public class Chami {

    @Id
    @Column(name = "username")
    private String username;

    @Column(unique = true)
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    public Chami (String username, String email, int age, String description){
        this.username = username;
        this.email = email;
        this.age = age;
        this.description = description;
    }

    public Chami(){}

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

    
}
