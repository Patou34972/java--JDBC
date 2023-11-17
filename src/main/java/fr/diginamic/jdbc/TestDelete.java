package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        System.out.println("bloc static");
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.pwd");
    }

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

            // Création de l'objet Statement
            statement = connection.createStatement();

            // Exemple d'insertion de données dans la table fournisseur
            String insertionQuery = "DELETE FROM FOURNISSEUR WHERE id = 4";
            statement.executeUpdate(insertionQuery);

            System.out.println("Delete réussie.");

            connection.close();
        } catch (SQLException e) {
            System.out.println("Attention : " + e.getMessage());
        } finally {
            try {
                // Fermeture du statement dans le bloc finally pour s'assurer que cela se fait même en cas d'exception
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture du statement : " + e.getMessage());
            }

            System.out.println("Fin du programme....");
        }
    }
}

