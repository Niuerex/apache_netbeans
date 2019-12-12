/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliars;

import classes.*;
import java.util.Scanner;

/**
 *
 * @author grup1
 */
public class IO {

    static Scanner sc = new Scanner(System.in);

    // Menus
    public static void imprimirMenu(String x) {

        String[] menuPrincipal = new String[5];
        menuPrincipal[0] = "Que vols gestionar?";
        menuPrincipal[1] = "(E) Empreses";
        menuPrincipal[2] = "(C) Centres";
        menuPrincipal[3] = "(I) Incidencies";
        menuPrincipal[4] = "(S) Sortir del programa";

        String[] menuEmpresa = new String[7];
        menuEmpresa[0] = "GESTIÓ D'EMPRESES";
        menuEmpresa[1] = "(A) Alta";
        menuEmpresa[2] = "(B) Baixa";
        menuEmpresa[3] = "(M) Modificar";
        menuEmpresa[4] = "(L) Llistar";
        menuEmpresa[5] = "(C) Consultar";
        menuEmpresa[6] = "(S) Sortir";

        String[] menuCentre = new String[7];
        menuCentre[0] = "GESTIÓ DE CENTRES";
        menuCentre[1] = "(A) Alta";
        menuCentre[2] = "(B) Baixa";
        menuCentre[3] = "(M) Modificar";
        menuCentre[4] = "(L) Llistar";
        menuCentre[5] = "(C) Consultar";
        menuCentre[6] = "(S) Sortir";

        String[] menuIncidencia = new String[6];
        menuIncidencia[0] = "GESTIÓ D'INCIDENCIES";
        menuIncidencia[1] = "(A) Crear";
        menuIncidencia[2] = "(B) Eliminar";
        menuIncidencia[3] = "(M) Modificar";
        menuIncidencia[4] = "(C) Consultar";
        menuIncidencia[5] = "(S) Sortir";

        String[] menuModificar = new String[8];
        menuModificar[0] = "QUÈ VOLS MODIFICAR?";
        menuModificar[2] = "(N) Nom";
        menuModificar[4] = "(E) Correu";
        menuModificar[5] = "(A) Adreça";
        menuModificar[6] = "(P) Codi Postal";
        menuModificar[7] = "(S) Sortir";

        if (x.equals("menuModificarCentre")) {
            menuModificar[1] = "(C) Codi Centre";
            menuModificar[3] = "(T) Tipus";
        } else if (x.equals("MenuModificarEmpresa")) {
            menuModificar[1] = "(C) NIF";
            menuModificar[3] = "(S) Sector";
        }

        String[] menuPrioritats = new String[3];
        menuPrioritats[0] = "(0) baixa";
        menuPrioritats[1] = "(1) normal";
        menuPrioritats[2] = "(2) urgent";

        String[] menuEstats = new String[4];
        menuEstats[0] = "(0) nova";
        menuEstats[1] = "(1) en curs";
        menuEstats[2] = "(2) resolta";
        menuEstats[3] = "(3) tancada";

        String[] menuModificarIncidencia = new String[8];
        menuModificarIncidencia[0] = "QUÈ VOLS MODIFICAR?";
        menuModificarIncidencia[1] = "(A) Assumpte";
        menuModificarIncidencia[2] = "(D) Descripcio";
        menuModificarIncidencia[3] = "(E) Estat";
        menuModificarIncidencia[4] = "(P) Prioritat";
        menuModificarIncidencia[5] = "(F) Data de resolucio";
        menuModificarIncidencia[6] = "(U) Usuari assignat";
        menuModificarIncidencia[7] = "(S) Sortir";

        switch (x) {//Cada variable és un menú diferent que imprimim
            case "menuPrincipal":
                for (int i = 0; i < menuPrincipal.length; i++) {
                    System.out.println(menuPrincipal[i]);
                }
                break;
            case "menuEmpresa":
                for (int i = 0; i < menuEmpresa.length; i++) {
                    System.out.println(menuEmpresa[i]);
                }
                break;
            case "menuCentre":
                for (int i = 0; i < menuCentre.length; i++) {
                    System.out.println(menuCentre[i]);
                }
                break;
            case "menuIncidencia":
                for (int i = 0; i < menuIncidencia.length; i++) {
                    System.out.println(menuIncidencia[i]);
                }
                break;
            case "menuModificarCentre":
                for (int i = 0; i < menuModificar.length; i++) {
                    System.out.println(menuModificar[i]);
                }
                break;
            case "menuModificarEmpresa":
                for (int i = 0; i < menuModificar.length; i++) {
                    System.out.println(menuModificar[i]);
                }
                break;
            case "menuPrioritats":
                for (int i = 0; i < menuPrioritats.length; i++) {
                    System.out.println(menuPrioritats[i]);
                }
                break;
            case "menuEstats":
                for (int i = 0; i < menuEstats.length; i++) {
                    System.out.println(menuEstats[i]);
                }
                break;
            case "menuModificarIncidencia":
                for (int i = 0; i < menuModificarIncidencia.length; i++) {
                    System.out.println(menuModificarIncidencia[i]);
                }
                break;
        }

    }

    //OUTPUT    
    public static void imprimirStringln(String n) {
        System.out.println(n);
    }

    public static void imprimirString(String n) {
        System.out.print(n + ' ');
    }

    public static void imprimirEntitat(Entitat e) {
        System.out.println(e);
    }

    public static void imprimirIncidencia(Incidencia i) {
        System.out.println(i);
    }

    // INPUT
    public static char llegirOpcio() {
        char a = Character.toUpperCase(sc.next().charAt(0));
        return a;
    }

    public static String llegirString() {
        String s = sc.next();
        return s;
    }

    public static int llegirInt() {
        int n = sc.nextInt();
        return n;
    }

    public static String llegirStringLine() {
        Scanner teclat = new Scanner(System.in);
        String s = teclat.nextLine();
        return s;
    }

}
