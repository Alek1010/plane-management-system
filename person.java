/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1965221_planemanagment;

/**
 *
 * @author alekm
 */
public class person {
    //person class which is going to be used in the ticket information class in the main program 
    private String name;
    private String surname;
    private String email;
    
    //contructor
    public person(String name, String surname, String email){
        this.name = name;
        this.surname=surname;
        this.email=email;
        
    }
    
    //getters and settings
    //name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //surname
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    //email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    
    public void printInfo(){
        System.out.println("name "+name);
        System.out.println("surname "+surname);
        System.out.println("email; "+email);
    }
    
    
}
