package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Customers;

public class Main {
	public static void main(String[] args) {
		// Se connecter à la base de données
		try {
			Connection connexion = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/tp5", 
					"brunobousquet", 
					"");

			PreparedStatement stmt6DelCstr = connexion.prepareStatement(
					"ALTER TABLE article "
					+ "DROP CONSTRAINT ART_AUTEUR1_FK");
			
			PreparedStatement stmt6AddCstr = connexion.prepareStatement(
					"ALTER TABLE article "
					+ "ADD CONSTRAINT ART_AUTEUR1_FK "
					+ "FOREIGN KEY (auteur) REFERENCES chercheur(matricule) ON DELETE CASCADE ");
			PreparedStatement stmt6Delete = connexion.prepareStatement(
					"DELETE FROM chercheur "
					+ "WHERE matricule in ( "
					+ "SELECT auteur "
					+ "FROM article "
					+ "WHERE soumisLe = '2007-05-16 00:00:00') ");

			PreparedStatement stmt9AddMedecine = connexion.prepareStatement(
					"INSERT INTO Departement "
					+ "(nom, dateCreation, adresse) "
					+ "VALUES ('Medecine', TO_DATE('01-03-2018','DD:MM:YYYY'), 'Gaspesie')");
			
			PreparedStatement stmt10AddPediatre = connexion.prepareStatement(
					"INSERT INTO Equipe "
					+ "(nom, departement) "
					+ "VALUES ('Pediatre', 'Medecine')");
			
			stmt10AddPediatre.execute();
					
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
