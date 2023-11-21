package fr.diginamic.jdbc.entites;

import java.util.ResourceBundle;

public class Fournisseur {
    private static long id;
    private static String nom;

    public Fournisseur() {
    }
    public Fournisseur(String nom) {
        this.nom = nom;
    }

    public Fournisseur(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        Fournisseur.id = id;
    }

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        Fournisseur.nom = nom;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", nom='" + nom + '\'' + "}";
    }

}
