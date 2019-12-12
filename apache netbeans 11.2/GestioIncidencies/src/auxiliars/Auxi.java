/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliars;

import classes.*;

/**
 *
 * @author alumne
 */
public class Auxi {

    public static void menu_centre(char opcio_menu, LlistaEntitats le) {
        do { // Imprimir el menu principal i executar funcions depenent de l'opcio
            IO.imprimirMenu("menuCentre");
            opcio_menu = IO.llegirOpcio();
            switch (opcio_menu) {
                case 'L':
                    le.llistar("centre");
                    break;
                case 'A':
                    le.alta("centre");
                    break;
                case 'B':
                    le.baixa("centre");
                    break;
                case 'C':
                    le.consulta("centre");
                    break;
                case 'M':
                    le.modificar("centre", le);
                    break;
            }

        } while (opcio_menu != 'S');
    }

    public static void menu_empresa(char opcio_menu, LlistaEntitats le) {
        do { // Imprimir el menu principal i executar funcions depenent de l'opcio
            IO.imprimirMenu("menuEmpresa");
            opcio_menu = IO.llegirOpcio();
            switch (opcio_menu) {
                case 'L':
                    le.llistar("empresa");
                    break;
                case 'A':
                    le.alta("empresa");
                    break;
                case 'B':
                    le.baixa("empresa");
                    break;
                case 'C':
                   le.consulta("empresa");
                    break;
                case 'M':
                    le.modificar("empresa", le);
                    break;
            }

        } while (opcio_menu != 'S');
    }

    public static void menu_incidencia(char opcio_menu, LlistaIncidencies li, LlistaEntitats le) {
        do { // Imprimir el menu principal i executar funcions depenent de l'opcio
            IO.imprimirMenu("menuIncidencia");
            opcio_menu = IO.llegirOpcio();
            switch (opcio_menu) {
                case 'A':
                    li.crear(le);
                    break;
                case 'B':
                    li.eliminar();
                    break;
                case 'M':
                    li.modificar(li);
                    break;
                case 'C':
                    li.consulta();
                    break;
            }

        } while (opcio_menu != 'S');
    }

    public static void menu_modificar_centre(char opcio_menu, LlistaEntitats le, int posicio) {
        do { // Imprimir el menu principal i executar funcions depenent de l'opcio
            IO.imprimirMenu("menuModificarCentre");
            opcio_menu = IO.llegirOpcio();
            switch (opcio_menu) {
                case 'C':
                    le.modificar_codi(posicio, "centre");
                    break;
                case 'N':
                    le.modificar_nom(posicio);
                    break;
                case 'E':
                    le.modificar_email(posicio);
                    break;
                case 'A':
                    le.modificar_adreca(posicio);
                    break;
                case 'P':
                    le.modificar_CP(posicio);
                    break;
                case 'T':
                    le.modificar_tipus_sector(posicio, "centre");
                    break;
            }

        } while (opcio_menu != 'S');
    }

    public static void menu_modificar_empresa(char opcio_menu, LlistaEntitats le, int posicio) {
        do { // Imprimir el menu principal i executar funcions depenent de l'opcio
            IO.imprimirMenu("menuModificarCentre");
            opcio_menu = IO.llegirOpcio();
            switch (opcio_menu) {
                case 'C':
                    le.modificar_codi(posicio, "empresa");
                    break;
                case 'N':
                    le.modificar_nom(posicio);
                    break;
                case 'E':
                    le.modificar_email(posicio);
                    break;
                case 'A':
                    le.modificar_adreca(posicio);
                    break;
                case 'P':
                    le.modificar_CP(posicio);
                    break;
                case 'S':
                    le.modificar_tipus_sector(posicio, "empresa");
                    break;
            }

        } while (opcio_menu != 'S');
    }

        public static void menu_modificar_incidencia(LlistaIncidencies li, int posicio) {
            char opcio_menu;
        do { // Imprimir el menu principal i executar funcions depenent de l'opcio
            IO.imprimirMenu("menuModificarIncidencia");
            opcio_menu = IO.llegirOpcio();
            switch (opcio_menu) {
                case 'A':
                    li.modify_Concern(posicio);
                    break;
                case 'D':
                    li.modify_Description(posicio);
                    break;
                case 'E':
                    li.modify_Status(posicio);
                    break;
                case 'P':
                    li.modify_Priority(posicio);
                    break;
                case 'F':
                    li.modify_Solved_date(posicio);
                    break;
                case 'U':
                    li.modify_Assigned_user(posicio);
                    break;
            }

        } while (opcio_menu != 'S');
    }
    
    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
