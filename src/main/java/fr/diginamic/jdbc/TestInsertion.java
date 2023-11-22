package fr.diginamic.jdbc;

import fr.digi.m0923.pedc.dal.jdbc.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ResourceBundle;


public class TestInsertion {

    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.pwd");
    }

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            statement = connection.createStatement();

            // Exemple de insert de données dans la table fournisseur
            String selectQuery = "INSERT INTO FOURNISSEUR (NOM) VALUES ('La Maison de la Peinture') ";
            resultSet = statement.executeQuery(selectQuery);

            // Afficher les résultats
            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                System.out.println("Nom : " + nom);
            }

            System.out.println("Insert réussie.");

        } catch (SQLException e) {
            System.out.println("Attention : " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture : " + e.getMessage());
            }

            System.out.println("Fin du programme....");
        }
    }


    }

