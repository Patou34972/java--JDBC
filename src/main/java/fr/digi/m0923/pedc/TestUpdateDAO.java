package fr.digi.m0923.pedc;

import fr.digi.m0923.pedc.dal.jdbc.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public class TestUpdateDAO {
    public static void main(String[] args) {
        try  {
            FournisseurDaoJdbc dao = new FournisseurDaoJdbc();
            int nb = dao.update("La Maison de la Peinture", "La Maison des Peintures");
            System.out.println("Nombre d'élèments modifiés : " + nb);
        } catch (SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }
    }

}


