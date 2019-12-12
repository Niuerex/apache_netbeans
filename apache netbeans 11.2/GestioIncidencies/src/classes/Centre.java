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
public class Centre extends Entitat {
    /* Atributs */
    private String codiCentre;
    private String tipus;
    
    /* Constructors */
    public Centre(String cc, String nom, String tipus, String correu, String adreca, String cp){
        super(nom, correu, adreca, cp);
        this.codiCentre = cc;
        this.tipus = tipus;
    }

    /* Getters */
    public String getCodiCentre(){
        return codiCentre;
    }
    
    public String getTipus() {
        return tipus;
    }
    
    /* Setters */
    public void setCodiCentre(String c){
        codiCentre = c;
    }
    
    public void setTipus(String t) {
        tipus = t;
    }
    
    //Metodes
    public String toString(){
        return "Codi: " + getCodiCentre() +" Nom: " + getNom() + " Correu: " + getEmail();
    }
    
}
