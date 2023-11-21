package fr.digi.m0923.pedc;

import fr.digi.m0923.pedc.dal.jdbc.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public class TestSelectDAO {
    public static void main(String[] args) {
        try  {
            FournisseurDaoJdbc dao = new FournisseurDaoJdbc();
            List<Fournisseur> fournisseurs;
            fournisseurs = dao.extraire();
            for (Fournisseur item : fournisseurs){
                System.out.println(item);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }

    }
}
