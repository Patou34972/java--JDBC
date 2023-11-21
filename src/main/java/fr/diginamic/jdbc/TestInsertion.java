package fr.diginamic.jdbc;

import fr.digi.m0923.pedc.dal.jdbc.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;


public class TestInsertion {

    public static void main(String[] args) {
        try {
            Fournisseur fournisseur = new Fournisseur( 5,"L\\'Espace creation");
            FournisseurDaoJdbc dao = new  FournisseurDaoJdbc();
            dao.insert(fournisseur);
        } catch (SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }

    }


    }

