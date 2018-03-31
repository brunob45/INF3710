import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import Model.Departement;
import Model.Equipe;
import Model.Chercheur;
import Model.Article;
import Persistence.PGeneric;

public class Main {

	public static void main(String[] args) {
		final int numero = 7;
		switch(numero) {
		case 1: {
			PGeneric<Departement> dManager = new PGeneric<Departement>(Departement.class);
			dManager.setUp();
			Departement departement = dManager.read("Informatique");
			System.out.println(departement);
			dManager.close();
			break;
		} 
		case 2:
		case 3: {
			PGeneric<Chercheur> cManager = new PGeneric<Chercheur>(Chercheur.class);
			cManager.setUp();
			List<Chercheur> chercheurs = cManager.get("Chercheur");
			for (Chercheur chercheur : chercheurs) {
				if(!chercheur.getArticles().isEmpty()) {
					System.out.println(chercheur);
					if(numero == 2) {
						for(Article article : chercheur.getArticles()) {
							System.out.println(article);
						}
					}
				}
			}
			cManager.close();
			break;
		}
		case 4:{
			PGeneric<Chercheur> cManager = new PGeneric<Chercheur>(Chercheur.class);
			cManager.setUp();
			Chercheur chercheur = cManager.read("M22556");
			System.out.println(chercheur);
			for(Article a : chercheur.getArticles()) {
				System.out.println(a);
			}
			cManager.close();
		}
		case 5:
			PGeneric<Article> aManager = new PGeneric<Article>(Article.class);
			aManager.setUp();
			List<Article> articles = aManager.get("Article");
			for(Article article : articles) {
				if(article.getDepartement().getNom().equals("Mathematiques")) {
					System.out.println("Removing " + article);
					aManager.remove(article);
				}
			}
			aManager.close();
			break;
		case 6:{
			PGeneric<Chercheur> cManager = new PGeneric<Chercheur>(Chercheur.class);
			cManager.setUp();
			List<Chercheur> chercheurs = cManager.get("Chercheur");
			for(Chercheur chercheur : chercheurs) {
				for(Article article : chercheur.getArticles()) {
					if(article.getSoumisLe().equals(LocalDate.of(2007,05,16))) {
						System.out.println("Removing " + chercheur);
						cManager.remove(chercheur);
						break;
					}
				}
			}
			cManager.close();
			break;
		}
		case 7: {
			// Crée le gestionnaire de table
			PGeneric<Departement> dManager = new PGeneric<Departement>(Departement.class);
			// Connecte a la table Postgres
			dManager.setUp();
			// SELECT * FROM Departement WHERE nom == "Physique"
			Departement departement = dManager.read("Physique");
			
			// J'annonce que je vais faire des changements
			dManager.beginTransaction();
			// Je fais le changement (aka je change l'adresse)
			departement.setAdresse("Quebec");
			// J'annonce que les modifications doivent être enregistrées
			dManager.commitTransaction();
			// Je ferme la connection /!\ IMPORTANT /!\ Sinon memory leak -> PC plante
			dManager.close();
			break;
		}
		case 8: {
			PGeneric<Departement> dManager = new PGeneric<Departement>(Departement.class);
			// Connecte a la table Postgres
			dManager.setUp();

			dManager.close();
			break;
		}

		case 9: {
			PGeneric<Departement> dManager = new PGeneric<Departement>(Departement.class);
			// Connecte a la table Postgres
			dManager.setUp();

			EntityManager em = getEntityManager();
			em.getTransaction.begin();

			Departement departement = new Departement();
			departement.setNom("Medecine");
			departement.setDateCreation("2018-03-01 00:00:00.0");
			departement.setAdresse("Gaspesie");

			em.persist(departement);
			em.getTransaction().commit();

			dManager.close();
			break;
		}

		case 10: {
			PGeneric<Departement> dManager = new PGeneric<Departement>(Departement.class);
			// Connecte a la table Postgres
			dManager.setUp();

			EntityManager em = getEntityManager();
			em.getTransaction.begin();

			Departement departement = new Departement();

			Equipe equipe = new Equipe();
			equipe.setNom("Pediatre");
			equipe.setDepartement(departement);

			em.persist(equipe);
			em.getTransaction().commit();
			dManager.close();
			break;
		}


		}
	}
}
