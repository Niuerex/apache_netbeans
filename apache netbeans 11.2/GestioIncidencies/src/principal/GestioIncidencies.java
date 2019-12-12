/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import classes.*;
import auxiliars.*;

/**
 *
 * @author Kevin Costes
 */
public class GestioIncidencies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestioIncidencies programa = new GestioIncidencies();
        programa.inici();
    }
    
    public void inici() {
        // variables
        char opcio_menu;
        LlistaEntitats le = new LlistaEntitats();
        LlistaIncidencies li = new LlistaIncidencies();
        
        LlistaEntitats.entitatsInicials();
        li.incidenciesInicials();
        
        
        do { // Imprimir el menu principal i executar funcions depenent de l'opcio
            IO.imprimirMenu("menuPrincipal");
            opcio_menu = IO.llegirOpcio();
            switch (opcio_menu) {
                case 'E':
                    Auxi.menu_empresa(opcio_menu, le);
                    break;
                case 'C':
                    Auxi.menu_centre(opcio_menu, le);
                    break;
                case 'I':
                    Auxi.menu_incidencia(opcio_menu, li, le);
                    break;
            }
            
        } while (opcio_menu != 'S');
        
    }
}
