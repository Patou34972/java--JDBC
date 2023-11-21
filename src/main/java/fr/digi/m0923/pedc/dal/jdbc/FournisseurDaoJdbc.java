package fr.digi.m0923.pedc.dal.jdbc;

import fr.digi.m0923.pedc.dal.FournissseurDAO;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements FournissseurDAO{
    public static final String DB_URL;
    public static final String DB_USER;
    public  static final String DB_PWD;

    static {
        System.out.println("bloc static");
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.pwd");

    }
    @Override
    public List<Fournisseur> extraire() throws SQLException {
        String EXTRAIRE_QUERY = "SELECT * FROM FOURNISSEUR";
        List<Fournisseur> fournisseursTrouves = new ArrayList<>();
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
            Statement st = cnx.createStatement();
            ResultSet curseur = st.executeQuery(EXTRAIRE_QUERY);

            while (curseur.next()) {
                int id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");

                Fournisseur fournisseurCourant = new Fournisseur(id, nom);
                fournisseursTrouves.add(fournisseurCourant);
            }
        }
        return fournisseursTrouves;
    }
    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        String nom = Fournisseur.getNom();
        long id = Fournisseur.getId();
        String INSERT_QUERY = "INSERT INTO FOURNISSEUR VALUES (" +id+ ",'" +nom+"')";
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
            System.out.println(cnx);
            try (Statement st = cnx.createStatement()) {
                int nb = st.executeUpdate(INSERT_QUERY);
                System.out.println("Nombre d'élèments inserés : " + nb);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());

        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        long id = Fournisseur.getId();
        String UPDATE_QUERY = "UPDATE FOURNISSEUR SET " +id+" ";
        return 0;
    }
    @Override
    public boolean delete(Fournisseur fournisseur) {
        return false;
    }
}
