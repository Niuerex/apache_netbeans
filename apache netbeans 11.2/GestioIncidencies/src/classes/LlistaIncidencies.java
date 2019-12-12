/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import auxiliars.*;
import static classes.LlistaEntitats.llista_entitats;

/**
 *
 * @author grup1
 */
public class LlistaIncidencies {

    static final int MAX_INCIDENCIES = 10;
    public static int incidenciesTotals = 0;
    static Incidencia[] llista_incidencies = new Incidencia[MAX_INCIDENCIES];

    public void incidenciesInicials() {
        /* Dades d'una incidencia int id, String concern, String description, int priority, String author
         */
        llista_incidencies[incidenciesTotals] = new Incidencia("No va PC", "He intentat obrir el PC pero no funciona", 1, "Josep", "Entitat");
        incidenciesTotals++;
        llista_incidencies[incidenciesTotals] = new Incidencia("No va impressora", "He intentat obrir el PC pero no funciona", 0, "Josep", "Entitat");
        incidenciesTotals++;
        llista_incidencies[incidenciesTotals] = new Incidencia("Internet no va", "He intentat obrir el PC pero no funciona", 1, "Josep", "Entitat");
        incidenciesTotals++;
        llista_incidencies[incidenciesTotals] = new Incidencia("Error al executar", "He intentat obrir el PC pero no funciona", 2, "Josep", "Entitat");
        incidenciesTotals++;
        
        // entitit objecte
        /*llista_incidencies[incidenciesTotals] = new Incidencia("No va PC", "He intentat obrir el PC pero no funciona", 1, "Josep", llista_entitats[incidenciesTotals]);
        incidenciesTotals++;
        llista_incidencies[incidenciesTotals] = new Incidencia("No va impressora", "He intentat obrir el PC pero no funciona", 0, "Josep", llista_entitats[incidenciesTotals]);
        incidenciesTotals++;
        llista_incidencies[incidenciesTotals] = new Incidencia("Internet no va", "He intentat obrir el PC pero no funciona", 1, "Josep", llista_entitats[incidenciesTotals]);
        incidenciesTotals++;
        llista_incidencies[incidenciesTotals] = new Incidencia("Error al executar", "He intentat obrir el PC pero no funciona", 2, "Josep", llista_entitats[incidenciesTotals]);
        incidenciesTotals++;
        */
    }

    /* El seguent metode serveix per a crear una incidencia
     */
    public void crear(LlistaEntitats le) {
        /* Aquest if comprova que la llista d'incidencies no estigui plena i 
            si ho esta mostra un missatge d'error i si no, segueix demanant les
            dades per a crear la incidencia.
         */
        if (incidenciesTotals < MAX_INCIDENCIES) {
            String concern, description, author, priority;
            int entitat, posicio = -1, priorityO = 0;

            // Aqui demanem la primera dada necessaria per a crear una incidencia
            IO.imprimirStringln("Creador de la incidencia (Nom):");
            /* Despres fem un bucle per a que mentre que l'usuari no insereix res
                encara que premi la tecla Intro, no el deixara continuar i li
                mostrara un missatge d'error. I el mateix procediment per a les
                seguents dades.
             */
            do {
                author = IO.llegirStringLine();
                if (author.equals("")) {
                    IO.imprimirStringln("Has d'introduir un nom!:");
                }
            } while (author.equals(""));

            /* Amb aquest while li preguntem a l'usuari qui crea la incidencia,
                si un centre o una empresa, i mentre que l'usuari no escolleix
                una empresa o centre valids, es seguira preguntant quin centre
                o empresa crea la incidencia.
             */
            while (posicio < 0) {
                IO.imprimirStringln("Incidencia creada per... (E)Empresa (C)Centre");
                char opcio;
                opcio = IO.llegirOpcio();
                if (opcio == 'E') {
                    IO.imprimirStringln("Empresa que crea la incidència");
                    int s = le.consulta("empresa");
                    if (s == -1) {
                        IO.imprimirStringln("Sense coincidencies!");
                    } else {
                        IO.imprimirStringln("Introdueix el NIF de l'empresa");
                        String nif = IO.llegirStringLine();

                        for (int i = 0; i < llista_entitats.length; i++) {
                            if (llista_entitats[i] instanceof Empresa) {
                                if (((Empresa) llista_entitats[i]).getNif().equals(nif)) {
                                    posicio = i;
                                }

                            }
                        }
                    }
                } else if (opcio == 'C') {
                    IO.imprimirStringln("Centre que crea la incidència");
                    int s = le.consulta("centre");
                    if (s == -1) {
                        IO.imprimirStringln("Sense coincidencies!");
                    } else {
                        IO.imprimirStringln("Introdueix el codi del centre");
                        String codi = IO.llegirStringLine();

                        for (int i = 0; i < llista_entitats.length; i++) {
                            if (llista_entitats[i] instanceof Centre) {
                                if (((Centre) llista_entitats[i]).getCodiCentre().equals(codi)) {
                                    posicio = i;
                                }

                            }
                        }
                    }
                }
            }

            IO.imprimirStringln("Assumpte de la incidencia:");
            do {
                concern = IO.llegirStringLine();
                if (concern.equals("")) {
                    IO.imprimirStringln("Has d'introduir un assumpte!:");
                }
            } while (concern.equals(""));

            IO.imprimirStringln("Descriu la incidencia:");
            do {
                description = IO.llegirStringLine();
                if (description.equals("")) {
                    IO.imprimirStringln("Has de descriure la incidencia!:");
                }
            } while (description.equals(""));

            IO.imprimirStringln("Prioritat de la incidencia:");
            IO.imprimirMenu("menuPrioritats");
            do {
                priority = IO.llegirStringLine();
                if (Auxi.isNumber(priority)) {
                    priorityO = Integer.parseInt(priority);
                    if (priorityO > 2 || priorityO < 0) {
                        IO.imprimirStringln("Has d'introduir una de les opcions!");
                    }
                }
            } while (priorityO > 2 || priorityO < 0);


            /* Finalment creem l'obecte incidencia amb totes les dades que ha 
                introduit l'usuari i afegim aquest objecte a l'array a la
                primera posicio lliure
             */
            llista_incidencies[incidenciesTotals] = new Incidencia(concern, description, priorityO, author, "Entitat"); // llista_entitats[posicio]
            incidenciesTotals++;
            IO.imprimirStringln("Incidencia creada correctament");
        } else {
            IO.imprimirStringln("No es poden emmagatzemar mes incidencies! Maxim actual: " + MAX_INCIDENCIES);
        }
    }
    
    public static void crearJframe(String concern, String description, int priority, String author, String entity) {
        llista_incidencies[incidenciesTotals] = new Incidencia(concern, description, priority, author, entity);
        incidenciesTotals++;
        
    }

    public void eliminar() {
        int posicio;
        int s = consulta();
        if (s == -1) {
            IO.imprimirStringln("Sense coincidencies!");
        } else {
            IO.imprimirStringln("Escriu l'ID de l'incidencia que vols borrar:");
            String id = IO.llegirString();
            int m = Integer.parseInt(id);
            for (int i = 0; i < incidenciesTotals; i++) {
                if (llista_incidencies[i].getId() == m) {
                    incidenciesTotals--;
                    posicio = i;
                    for (int j = posicio; j < incidenciesTotals; j++) {
                        llista_incidencies[j+1].setId(llista_incidencies[j + 1].getId() - 1);
                        llista_incidencies[j] = llista_incidencies[j + 1];
                    }
                }
            }
        }
    }
    
        public static void eliminarJframe(int id) {
            int posicio;
            for (int i = 0; i < incidenciesTotals; i++) {
                if (llista_incidencies[i].getId() == id) {
                    incidenciesTotals--;
                    posicio = i;
                    for (int j = posicio; j < incidenciesTotals; j++) {
                        llista_incidencies[j+1].setId(llista_incidencies[j + 1].getId() - 1);
                        llista_incidencies[j] = llista_incidencies[j + 1];
                    }
                }
            }
    }

    public void modificar(LlistaIncidencies li) {
        if (incidenciesTotals == 0) {
            IO.imprimirStringln("Has d'afegir projectes abans de poder modificar-ne\n");
        } else {
            int posicio = -1;
            consulta();
            IO.imprimirStringln("Introdueix la ID de la incidencia que vols modificar:");
            int id = IO.llegirInt();
            if (id >= incidenciesTotals && id < 0) {
                IO.imprimirStringln("No existeix cap incidencia amb aquesta ID\n");
            } else {
                IO.imprimirStringln("ID: " + llista_incidencies[id].getId()
                        + " Entitat: " + llista_incidencies[id].getEntity()
                        + " Asumpte: " + llista_incidencies[id].getConcern()
                        + " Descripcio: " + llista_incidencies[id].getDescription()
                        + " Estat: " + llista_incidencies[id].getStatus()
                        + " Prioritat: " + llista_incidencies[id].getPriority()
                        + " Creada: " + llista_incidencies[id].getCreation_date()
                        + " Solucionada: " + llista_incidencies[id].getSolved_date()
                        + " Assignada a: " + llista_incidencies[id].getAssigned_user()
                        + " Creador: " + llista_incidencies[id].getAuthor());
                posicio = 2;
                Auxi.menu_modificar_incidencia(li, posicio);

            }
        }
    }

    public static int consulta() {
        String cerca, comparar;
        int s = -1;
        IO.imprimirStringln("Cercar:");
        cerca = (IO.llegirStringLine()).toLowerCase();
        if (cerca.equals("")) {
            for (int i = 0; i < incidenciesTotals; i++) {
                IO.imprimirStringln("ID: " + llista_incidencies[i].getId()
                        + " Entitat: " + llista_incidencies[i].getEntity()
                        + " Asumpte: " + llista_incidencies[i].getConcern()
                        + " Descripcio: " + llista_incidencies[i].getDescription()
                        + " Estat: " + llista_incidencies[i].getStatus()
                        + " Prioritat: " + llista_incidencies[i].getPriority()
                        + " Creada: " + llista_incidencies[i].getCreation_date()
                        + " Solucionada: " + llista_incidencies[i].getSolved_date()
                        + " Assignada a: " + llista_incidencies[i].getAssigned_user()
                        + " Creador: " + llista_incidencies[i].getAuthor());
            }
        } else {
            s = 1;
            for (int i = 0; i < incidenciesTotals; i++) {
                comparar = Incidencia.toString(llista_incidencies[i]);
                if (comparar.contains(cerca)) {
                    s = 1;
                    IO.imprimirStringln("ID: " + llista_incidencies[i].getId()
                            + " Entitat: " + llista_incidencies[i].getEntity()
                            + " Asumpte: " + llista_incidencies[i].getConcern()
                            + " Descripcio: " + llista_incidencies[i].getDescription()
                            + " Estat: " + llista_incidencies[i].getStatus()
                            + " Prioritat: " + llista_incidencies[i].getPriority()
                            + " Creada: " + llista_incidencies[i].getCreation_date()
                            + " Solucionada: " + llista_incidencies[i].getSolved_date()
                            + " Assignada a: " + llista_incidencies[i].getAssigned_user()
                            + " Creador: " + llista_incidencies[i].getAuthor());
                }
            }
        }
        return s;
    }

    /* METODES PER A MODIFICAR */
    public void modify_Concern(int posicio) {
        IO.imprimirStringln("Asumpte actual: " + llista_incidencies[posicio].getConcern());
        String newConcern = IO.llegirStringLine();
        if (!newConcern.equals("")) {
            llista_incidencies[posicio].setConcern(newConcern);
            IO.imprimirStringln("Assumpte modificat correctament!");
        } else {
            IO.imprimirStringln("No s'han realitzat canvis");
        }
    }

    public void modify_Description(int posicio) {
        IO.imprimirStringln("Descripcio actual: " + llista_incidencies[posicio].getDescription());
        String newDescription = IO.llegirStringLine();
        if (!newDescription.equals("")) {
            llista_incidencies[posicio].setDescription(newDescription);
            IO.imprimirStringln("Descripcio modificada correctament!");
        } else {
            IO.imprimirStringln("No s'han realitzat canvis");
        }
    }

    public void modify_Status(int posicio) {
        IO.imprimirStringln("Estat actual: " + llista_incidencies[posicio].getStatus());
        IO.imprimirMenu("menuEstats");
        int newStatus = IO.llegirInt();
        if (newStatus <= 3 && newStatus > -1) {
            llista_incidencies[posicio].setStatus(newStatus);
            IO.imprimirStringln("Estat modificat correctament!");
        } else {
            IO.imprimirStringln("No s'han realitzat canvis");
        }
    }

    public void modify_Priority(int posicio) {
        IO.imprimirStringln("Prioritat actual: " + llista_incidencies[posicio].getPriority() + "\nPossibles prioritats:");
        IO.imprimirMenu("menuPrioritats");
        int newPriority = IO.llegirInt();
        if (newPriority <= 3 && newPriority > -1) {
            llista_incidencies[posicio].setPriority(newPriority);
            IO.imprimirStringln("Prioritat modificada correctament!");
        } else {
            IO.imprimirStringln("No s'han realitzat canvis");
        }
    }

    public void modify_Solved_date(int posicio) {
        if (llista_incidencies[posicio].getSolved_date() == null) {
            IO.imprimirStringln("Aquesta incidencia no ha estat solucionada\nIntrodueix la data de resolucio si cal:");
        } else {
            IO.imprimirStringln("Solucionada el: " + llista_incidencies[posicio].getSolved_date());
        }
        IO.imprimirStringln("(dd/mm/aaaa)");
        String newSolved_date = IO.llegirStringLine();
        if (!newSolved_date.equals("")) {
            llista_incidencies[posicio].setSolved_date(newSolved_date);
            IO.imprimirStringln("Data de resolucio modificada correctament!");
        } else {
            IO.imprimirStringln("No s'han realitzat canvis");

        }
    }

    public void modify_Assigned_user(int posicio) {
        IO.imprimirStringln("Incidencia assignada a: " + llista_incidencies[posicio].getAssigned_user());
        String newAssigned_user = IO.llegirStringLine();
        if (!newAssigned_user.equals("")) {
            llista_incidencies[posicio].setAssigned_user(newAssigned_user);
            IO.imprimirStringln("Usuari modificat correctament!");
        } else {
            IO.imprimirStringln("No s'han realitzat canvis");
        }
    }
    
    public Incidencia[] returnList() {
        return llista_incidencies;
    }

}
