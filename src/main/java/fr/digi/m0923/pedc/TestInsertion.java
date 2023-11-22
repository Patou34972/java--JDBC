package fr.digi.m0923.pedc;

import fr.digi.m0923.pedc.dal.jdbc.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;

public class TestInsertion {

    public static void main(String[] args) {

        try {
            //inserer un fournisseur dont le nom « La Maison de la Peinture »
            Fournisseur fournisseur = new Fournisseur("La Maison de la Peinture");
            FournisseurDaoJdbc dao  = new FournisseurDaoJdbc();
            dao.insert(fournisseur);

            //inserer un fournisseur dont le nom « L’Espace Création »
            fournisseur.setNom("L’Espace Création");
            dao.insert(fournisseur);
        } catch (SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }

    }

}

