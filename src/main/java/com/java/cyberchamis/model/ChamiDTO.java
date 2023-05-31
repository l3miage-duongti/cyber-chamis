package com.java.cyberchamis.model;

public class ChamiDTO {

    private String email;
    private String username;
    private int age;

    public ChamiDTO(String email, String username, int age){
        this.email = email;
        this.username = username;
        this.age = age;
    }

    public String getEmail(){ return this.email; }

    public void setEmail(String email){ this.email = email; }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}