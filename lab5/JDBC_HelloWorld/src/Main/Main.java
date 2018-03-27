package Main;

import java.sql.Connection;
import java.sql.DriverManager;
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
			Statement stmt = connexion.createStatement();
			ResultSet results = stmt.executeQuery("select * from chercheur, article where matricule = auteur and matricule in (select auteur from article)");
			ResultSetMetaData metadata=  results.getMetaData();
			System.out.println(metadata.getColumnCount());
			while (results.next()) {
					System.out.print(results.getString("matricule")+", ");
					System.out.print(results.getString("prenom")+", ");
					System.out.print(results.getString("nom")+", ");
					System.out.print(results.getString("position")+", ");
					System.out.print(results.getString("equipe")+", ");
					System.out.println(results.getInt("salaire")+", ");

					System.out.print("  "+results.getString("auteur")+", ");
					System.out.print("  "+results.getString("coauteur")+", ");
					System.out.print("  "+results.getDate("soumisLe")+", ");
					System.out.println("  "+results.getString("departement"));
			}
			
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
