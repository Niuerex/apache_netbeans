/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import auxiliars.*;

/**
 *
 * @author alumne
 */
public class LlistaEntitats {

    static final int MAX = 20;
    static int contador = 0;
    static Entitat[] llista_entitats = new Entitat[MAX];

    public static void entitatsInicials() {
        llista_entitats[0] = new Centre("224", "Institut Montsià", "Fromació Professional", "institutmontsia@iesmontsia.org", "C/ Rey", "43870");
        llista_entitats[1] = new Centre("718", "Institut Alfacs", "Fromació Professional", "institutalfacs@gmail.org", "C/ Sant Isidre", "43840");
        llista_entitats[2] = new Centre("903", "Institut de l'Ebre", "Fromació Professional", "institutebre@ebre.org", "C/ Galera", "43890");
        llista_entitats[3] = new Empresa("6526", "Julivert Barberà", "Agrícola", "julivertbarbera@gmail.com", "C/ Rey", "43870");
        llista_entitats[4] = new Empresa("2346", "Infoclic", "Informàtica", "infoclic@gmail.com", "C/ Sant Isidre", "43840");
        llista_entitats[5] = new Empresa("9017", "Manain", "Maquinària", "manain@gmail.com", "C/ Galera", "43890");
        contador = 6;
    }

    public void llistar(String e) {

        if (e.equals("centre")) {
            for (int i = 0; i < contador; i++) {
                if (llista_entitats[i] instanceof Centre) {
                    IO.imprimirEntitat(llista_entitats[i]);
                }
            }
        } else if (e.equals("empresa")) {
            for (int i = 0; i < contador; i++) {
                if (llista_entitats[i] instanceof Empresa) {
                    IO.imprimirEntitat(llista_entitats[i]);
                }
            }
        }

    }

    public int consulta(String e) {
        IO.imprimirStringln("Que vols buscar?");
        String b = IO.llegirString();
        int s = -1;

        for (int i = 0; i < contador; i++) {
            String x = llista_entitats[i].toString();
            if (x.toLowerCase().contains(b.toLowerCase())) {

                if (e.equals("centre")) {
                    if (llista_entitats[i] instanceof Centre) {
                        IO.imprimirEntitat(llista_entitats[i]);
                        s = 1;
                    }
                } else if (e.equals("empresa")) {
                    if (llista_entitats[i] instanceof Empresa) {
                        IO.imprimirEntitat(llista_entitats[i]);
                        s = 1;
                    }
                }
            }
        }
        return s;
    }

    public void alta(String e) {
        String codi = null;
        String tipussector = null;
        if (contador == llista_entitats.length) {
            IO.imprimirStringln("No hi ha lloc per a mes professors");
        } else {
            if (e.equals("centre")) {
                IO.imprimirStringln("Introdueix el CODI del centre que vols donar d'alta:");
                codi = IO.llegirString();

            } else if (e.equals("empresa")) {
                IO.imprimirStringln("Introdueix el NIF de l'empresa que vols donar d'alta:");
                codi = IO.llegirString();
            }

            IO.imprimirStringln("Introdueix el NOM de l'entitat que vols donar d'alta:");
            String nom = IO.llegirString();

            if (e.equals("centre")) {
                IO.imprimirStringln("Introdueix el TIPUS de l'institut que vols donar d'alta:");
                tipussector = IO.llegirString();
            } else if (e.equals("empresa")) {
                IO.imprimirStringln("Introdueix el SECTOR de l'empresa que vols donar d'alta:");
                tipussector = IO.llegirString();
            }

            IO.imprimirStringln("Introdueix el CORREU de l'entitat que vols donar d'alta:");
            String correu = IO.llegirString();
            IO.imprimirStringln("Introdueix l'ADREÇA de l'entitat que vols donar d'alta:");
            String adreca = IO.llegirString();
            IO.imprimirStringln("Introdueix el CODI POSTAL de l'entitat que vols donar d'alta:");
            String codiPostal = IO.llegirString();
            if (e.equals("centre")) {
                llista_entitats[contador] = new Centre(codi, nom, tipussector, correu, adreca, codiPostal);
            } else if (e.equals("empresa")) {
                llista_entitats[contador] = new Empresa(codi, nom, tipussector, correu, adreca, codiPostal);
            }
            contador++;
        }
    }

    public void baixa(String e) {
        String n;
        int p;
        int s;
        if (e.equals("centre")) {
            s = consulta("centre");
            if (s == -1) {
                IO.imprimirStringln("No s'han trobat coincidencies");
            } else {
                IO.imprimirStringln("Escriu el Codi del centre que vols donar de baixa:");
                n = IO.llegirString();
                for (int i = 0; i < contador; i++) {
                    if (((Centre) llista_entitats[i]).getCodiCentre().equals(n)) {
                        contador--;
                        p = i;
                        for (int j = p; j < contador; j++) {
                            llista_entitats[j] = llista_entitats[j + 1];
                        }
                    }
                }
            }
        } else if (e.equals("empresa")) {
            s = consulta("empresa");
            if (s == -1) {
                IO.imprimirStringln("No s'han trobat coincidencies");
            } else {
                IO.imprimirStringln("Escriu el NIF de l'empresa que vols donar de baixa:");
                n = IO.llegirString();
                for (int i = 0; i < contador; i++) {
                    if (((Empresa) llista_entitats[i]).getNif().equals(n)) {
                        contador--;
                        p = i;
                        for (int j = p; j < contador; j++) {
                            llista_entitats[j] = llista_entitats[j + 1];
                        }
                    }
                }
            }
        }
    }

    public void modificar(String e, LlistaEntitats le) {
        char opcio_menu = ' ';
        int posicio = -1;
        if (e.equals("centre")) {
            String codicentre;
            int s = consulta("centre");

            if (s == -1) {
                IO.imprimirStringln("No s'han trobat coincidencies");
            } else {
                IO.imprimirStringln("Escriu el Codi del centre que vols modificar:");
                codicentre = IO.llegirString();

                for (int i = 0; i < contador; i++) {
                    if (llista_entitats[i] instanceof Centre) {
                        if (((Centre) llista_entitats[i]).getCodiCentre().equals(codicentre)) {
                            posicio = i;
                        }
                    }
                }

                if (posicio != -1) {
                    Auxi.menu_modificar_centre(opcio_menu, le, posicio);
                } else {
                    IO.imprimirStringln("No s'ha trobat cap coincidencia:");
                }
            }

        } else if (e.equals("empresa")) {
            String nif;
            int s = consulta("empresa");

            if (s == -1) {
                IO.imprimirStringln("No s'han trobat coincidencies");
            } else {
                IO.imprimirStringln("Escriu el NIF de l'empresa que vols modificar:");
                nif = IO.llegirString();

                for (int i = 0; i < contador; i++) {
                    if (llista_entitats[i] instanceof Empresa) {
                        if (((Empresa) llista_entitats[i]).getNif().equals(nif)) {
                            posicio = i;
                        }
                    }
                }

                if (posicio != -1) {
                    Auxi.menu_modificar_centre(opcio_menu, le, posicio);
                } else {
                    IO.imprimirStringln("No s'ha trobat cap coincidencia:");
                }
            }

        }

    }

    /* Mètodes secundaris */
    public void modificar_codi(int p, String e) {
        if (e.equals("centre")) {
            IO.imprimirStringln("Introdueix el nou CODI del centre:");
            String n = IO.llegirString();
            ((Centre) llista_entitats[p]).setCodiCentre(n);
        } else if (e.equals("empresa")) {
            IO.imprimirStringln("Introdueix el nou NIF de l'empresa:");
            String n = IO.llegirString();
            ((Empresa) llista_entitats[p]).setNif(n);
        }
    }

    public void modificar_nom(int p) {
        IO.imprimirStringln("Introdueix el nou NOM de l'entitat:");
        String n = IO.llegirString();
        llista_entitats[p].setNom(n);
    }

    public void modificar_email(int p) {
        IO.imprimirStringln("Introdueix el nou CORREU de l'entitat:");
        String n = IO.llegirString();
        llista_entitats[p].setEmail(n);
    }

    public void modificar_adreca(int p) {
        IO.imprimirStringln("Introdueix la nova ADREÇA de l'entitat:");
        String n = IO.llegirString();
        llista_entitats[p].setAddress(n);
    }

    public void modificar_CP(int p) {
        IO.imprimirStringln("Introdueix el nou Codi Postal de l'entitat:");
        String n = IO.llegirString();
        llista_entitats[p].setCp(n);
    }

    public void modificar_tipus_sector(int p, String e) {
        if (e.equals("centre")) {
            IO.imprimirStringln("Introdueix el nou TIPUS de centre:");
            String n = IO.llegirString();
            ((Centre) llista_entitats[p]).setTipus(n);
        } else if (e.equals("empresa")) {
            IO.imprimirStringln("Introdueix el nou SECTOR de l'empresa:");
            String n = IO.llegirString();
            ((Empresa) llista_entitats[p]).setSector(n);
        }
    }
}
