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
public class Empresa extends Entitat {

    /* Atributs */
    private String nif;
    private String sector;

    /* Amb aquesta variable, guardem el correu de l'empresa */

 /* Constructors */
 /* Amb aquest constructor realitzem la creació d'una empresa, indicant-ne tota la seva informació */
    public Empresa(String nif, String nom, String sector, String correu, String adreca, String cp) {
        super(nom, correu, adreca, cp);
        this.nif = nif;
        this.sector = sector;
    }

    /* Getters */
    public String getNif() {
        return nif;
    }

    public String getSector() {
        return sector;
    }

    /* Setters */
    public void setNif(String n) {
        nif = n;
    }

    public void setSector(String s) {
        sector = s;
    }


    /* Mètodes*/
    public String toString() {
        return "NIF: " + getNif() + " Nom: " + getNom() + " Correu: " + getEmail();
    }
}
