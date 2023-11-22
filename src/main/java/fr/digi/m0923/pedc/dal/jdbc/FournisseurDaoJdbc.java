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
    private static final String SQL_SELECT = "SELECT * FROM FOURNISSEUR";
    private static final String SQL_INSERT = "INSERT INTO FOURNISSEUR (NOM) VALUES (?)";
    private static final String SQL_UPDATE = "UPDATE FOURNISSEUR SET NOM = ? WHERE NOM = ?";
    private static final String SQL_DELETE = "DELETE FROM FOURNISSEUR WHERE NOM =?";
    @Override
    public List<Fournisseur> extraire() throws SQLException {
        List<Fournisseur> fournisseursTrouves = new ArrayList<>();
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement();
             ResultSet curseur = st.executeQuery(SQL_SELECT);) {
            System.out.println(cnx);

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
        String nom = fournisseur.getNom();

        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement pst = cnx.prepareStatement(SQL_INSERT)) {
            System.out.println(cnx);
            pst.setString(1,nom);
            int nb = pst.executeUpdate();
            System.out.println("Nombre d'élèments modifiés : " + nb);
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException  {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement pst = cnx.prepareStatement(SQL_UPDATE)) {
            System.out.println(cnx);
            pst.setString(1,nouveauNom);
            pst.setString(2,ancienNom);
            cnx.setAutoCommit(false);
            int nb = pst.executeUpdate();
            cnx.commit();
            return nb;
        }
    }
    @Override
    public boolean delete(Fournisseur fournisseur) throws SQLException {
        String nom = fournisseur.getNom();

        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement pst = cnx.prepareStatement(SQL_DELETE)) {
            System.out.println(cnx);
            pst.setString(1,nom);

            int nb = pst.executeUpdate();
            System.out.println("Nombre d'élèments supprimés : " + nb);
            return nb > 0;
        }
    }
}
