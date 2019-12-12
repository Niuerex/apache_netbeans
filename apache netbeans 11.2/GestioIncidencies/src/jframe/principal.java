/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import classes.*;
/**
 *
 * @author alumne
 */
public class principal {
    
    public static void main(String[] args) {
        LlistaIncidencies li = new LlistaIncidencies();
        li.incidenciesInicials();
        jframe_principal j = new jframe_principal(li);
        j.setVisible(true);
    }
}
