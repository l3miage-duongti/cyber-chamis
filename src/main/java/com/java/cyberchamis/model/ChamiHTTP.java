package com.java.cyberchamis.model;

import java.util.List;

public class ChamiHTTP{

    String login;
    int age;
    List<String> defisCrees;

    public ChamiHTTP(String login, int age, List<String> defisCrees){
        this.login = login;
        this.age = age;
        this.defisCrees = defisCrees;
    }

    public ChamiHTTP() {
    }

    public void addTodefisCrees(String idDefi){
        this.defisCrees.add(idDefi);
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public List<String> getdefisCrees() {
        return defisCrees;
    }
    public void setdefisCrees(List<String> defisCrees) {
        this.defisCrees = defisCrees;
    }
}