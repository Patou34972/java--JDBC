package fr.digi.m0923.pedc;

import fr.digi.m0923.pedc.dal.jdbc.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;

public class TestDeleteDAO {
    public static void main(String[] args) {
        try {
            Fournisseur fournisseur = new Fournisseur("La Maison des Peintures");
            FournisseurDaoJdbc dao = new FournisseurDaoJdbc();
            boolean isDeleted = dao.delete(fournisseur);
            System.out.println("Fournisseur : " + fournisseur.getNom() + " deleted : " + isDeleted);
        } catch (
                SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }
    }
}
