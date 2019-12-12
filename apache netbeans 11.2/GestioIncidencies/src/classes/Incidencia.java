/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.*;

/**
 *
 * @author alumne
 */
public class Incidencia {

    private int id;
    private String concern;
    private String description;
    private static final String[] POSSIBLE_STATUS = {"nova", "en curs", "resolta", "tancada"};
    private int status;
    private static final String[] POSSIBLE_PRIORITY = {"baixa", "normal", "urgent"};
    private int priority;
    private LocalDate creation_date;
    private String solved_date;
    private String assigned_user;
    private String author;
    private String assigned_entity;

    public Incidencia(String concern, String description, int priority, String author, String assigned_entity) {
        this.id = LlistaIncidencies.incidenciesTotals;
        this.concern = concern;
        this.description = description;
        this.status = 0;
        this.priority = priority;
        this.creation_date = LocalDate.now();
        this.solved_date = null;
        this.assigned_user = "Tecnic";
        this.author = author;
        this.assigned_entity = assigned_entity;

    }

    // Getters
    public String getEntity() {
        return assigned_entity;
        // return assigned_entity.getNom();
    }

    public int getId() {
        return id;
    }

    public String getConcern() {
        return concern;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        String s = "";
        for (int i = 0; i < POSSIBLE_STATUS.length; i++) {
            if (i == status) {
                s = POSSIBLE_STATUS[i];
            }
        }
        return s;
    }

    public String getPriority() {
        String p = "";
        for (int i = 0; i < POSSIBLE_PRIORITY.length; i++) {
            if (i == priority) {
                p = POSSIBLE_PRIORITY[i];
            }
        }
        return p;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public String getSolved_date() {
        return solved_date;
    }

    public String getAssigned_user() {
        return assigned_user;
    }

    public String getAuthor() {
        return author;
    }

    // Setters
    //public void setEntitat(Entitat e) {
      //  assigned_entity = e;
    //}

    public void setId(int i) {
        id = i;
    }

    public void setConcern(String c) {
        concern = c;
    }

    public void setDescription(String d) {
        description = d;
    }

    public void setStatus(int s) {
        status = s;
    }

    public void setPriority(int p) {
        priority = p;
    }

    public void setSolved_date(String sd) {
        solved_date = sd;
    }

    public void setAssigned_user(String au) {
        assigned_user = au;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public static String toString(Incidencia incidencia) {
        return (incidencia.getId() + " "
                + incidencia.getEntity()
                + " " + incidencia.getConcern()
                + " " + incidencia.getDescription()
                + " " + incidencia.getStatus()
                + " " + incidencia.getPriority()
                + " " + incidencia.getCreation_date()
                + " " + incidencia.getSolved_date()
                + " " + incidencia.getAssigned_user()
                + " " + incidencia.getAuthor()).toLowerCase();
    }
}
