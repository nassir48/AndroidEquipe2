package com.go.by.ter.model;

import java.io.Serializable;

public class Reservations implements Serializable {
    private String prenom, nom, jour, depart, arrivee, etat, telephone, nbPlace;

    public Reservations() {
    }

    public Reservations(String prenom, String nom, String jour, String depart, String arrivee, String etat, String telephone, String nbPlace) {
        this.prenom = prenom;
        this.nom = nom;
        this.jour = jour;
        this.depart = depart;
        this.arrivee = arrivee;
        this.etat = etat;
        this.telephone = telephone;
        this.nbPlace = nbPlace;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(String nbPlace) {
        this.nbPlace = nbPlace;
    }
}
