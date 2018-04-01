import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import Model.Article;
import Model.Chercheur;
import Model.Departement;
import Model.Equipe;
import Persistence.AbstractPersistence;


public class Main {
	public static void main(String[] args) {
		System.out.println(1); 
		{
			AbstractPersistence<Departement> pManager = 
					new AbstractPersistence<Departement>(Departement.class);
			pManager.setUp();
			pManager.ouvrirSession();
			Departement d = pManager.read("Informatique");
			System.out.println(d);
			pManager.fermerSession();
			pManager.close();
		} 
		System.out.println(2);
		{
			AbstractPersistence<Chercheur> cManager = 
					new AbstractPersistence<Chercheur>(Chercheur.class);
			cManager.setUp();
			cManager.ouvrirSession();
			List<Chercheur> chercheurs = cManager.read();
			for (Chercheur chercheur : chercheurs) {
				if(!chercheur.getArticles().isEmpty()) {
					System.out.println(chercheur);
				}
			}
			cManager.fermerSession();
			cManager.close();
		}
		System.out.println(3);
		{
			AbstractPersistence<Chercheur> cManager = 
					new AbstractPersistence<Chercheur>(Chercheur.class);
			cManager.setUp();
			cManager.ouvrirSession();
			List<Chercheur> chercheurs = cManager.read();
			for (Chercheur chercheur : chercheurs) {
				if(!chercheur.getArticles().isEmpty()) {
					System.out.println(chercheur);
					for(Article article : chercheur.getArticles()) {
						System.out.println(article);
					}
				}
			}
			cManager.fermerSession();
			cManager.close();
		}
		System.out.println(4);
		{
			AbstractPersistence<Chercheur> cManager = 
					new AbstractPersistence<Chercheur>(Chercheur.class);
			cManager.setUp();
			cManager.ouvrirSession();
			Chercheur chercheur = cManager.read("M22556");
			System.out.println(chercheur);
			for(Article a : chercheur.getArticles()) {
				System.out.println(a);
			}
			cManager.fermerSession();
			cManager.close();
		}
		System.out.println(5);
		{
			AbstractPersistence<Article> aManager =
					new AbstractPersistence<Article>(Article.class);
			aManager.setUp();
			aManager.ouvrirSession();
			List<Article> articles = aManager.read();
			for(Article article : articles) {
				if(article.getDepartement().getNom().equals("Mathematiques")) {
					System.out.println("Removing " + article);
					aManager.remove(article);
				}
			}
			aManager.fermerSession();
			aManager.close();
		}
		System.out.println(6);
		{
			AbstractPersistence<Chercheur> cManager =
					new AbstractPersistence<Chercheur>(Chercheur.class);
			AbstractPersistence<Article> aManager =
					new AbstractPersistence<Article>(Article.class);
			cManager.setUp();
			cManager.ouvrirSession();
			List<Chercheur> chercheurs = cManager.read();
			for(Chercheur chercheur : chercheurs) {
				for(Article article : chercheur.getArticles()) {
					if(article.getSoumisLe().toLocalDate().equals(LocalDate.of(2007,05,16))) {
						System.out.println("Removing " + chercheur);
						cManager.remove(chercheur);
						break;
					}
				}
			}
			cManager.fermerSession();
			cManager.close();
		}
		System.out.println(7);
		{
			AbstractPersistence<Departement> dManager =
					new AbstractPersistence<Departement>(Departement.class);
			dManager.setUp();
			dManager.ouvrirSession();
			Departement departement = dManager.read("Physique");
			
			departement.setAdresse("Quebec");
			dManager.update(departement);
			
			dManager.fermerSession();
			dManager.close();
		}
		System.out.println(8); 
		{
			AbstractPersistence<Chercheur> cManager =
					new AbstractPersistence<Chercheur>(Chercheur.class);
			cManager.setUp();
			cManager.ouvrirSession();
			List<Chercheur> chercheurs = cManager.read();
			for(Chercheur chercheur : chercheurs) {
				if(chercheur.getPosition().equalsIgnoreCase("postdoc") 
					&& chercheur.getEquipe().getDepartement().getNom().equalsIgnoreCase("Physique")) { // Il y a personne en Maths au postdoc :
					chercheur.setPosition("maitrise");
					System.out.println("Updating " + chercheur);
					cManager.update(chercheur);
				}
			}
			System.out.println("Done.");
			cManager.fermerSession();
			cManager.close();
		}
		System.out.println(9);
		{
			AbstractPersistence<Departement> dManager =
					new AbstractPersistence<Departement>(Departement.class);
			dManager.setUp();
			dManager.ouvrirSession();

			Departement departement = new Departement();
			departement.setNom("Medecine");
			departement.setDateCreation(Date.valueOf(LocalDate.of(2018, 03, 01)));
			departement.setAdresse("Gaspesie");

			dManager.add(departement);
			dManager.fermerSession();
			dManager.close();
		}
		System.out.println(10);
		{
			AbstractPersistence<Equipe> eManager =
					new AbstractPersistence<Equipe>(Equipe.class);
			AbstractPersistence<Departement> dManager =
					new AbstractPersistence<Departement>(Departement.class);
			
			dManager.setUp();
			dManager.ouvrirSession();
			
			Equipe equipe = new Equipe();
			equipe.setNom("Pediatre");
			Departement medecine = dManager.read("Medecine");
			equipe.setDepartement(medecine);
			eManager.add(equipe);

			dManager.fermerSession();
			dManager.close();
		}
	}
}
