/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author alumne
 */
public class Entitat {
    private String nom;
    private String email;
    private String address;
    private String cp;
    
    public Entitat(String nom, String email, String adreca, String cp) {
        this.nom = nom;
        this.email = email;
        this.address = adreca;
        this.cp = cp;
    }
    
    // Getters
    
    public String getNom() {
        return nom;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getCp() {
        return cp;
    }
    
    // Setters
    public void setNom(String n) {
        nom = n;
    }
    
    public void setEmail(String e) {
        email = e;
    }
    
    public void setAddress(String a) {
        address = a;
    }
    
    public void setCp(String c) {
        cp = c;
    }
    
}