import java.time.LocalDate;
import java.util.List;

import Model.Article;
import Model.Chercheur;
import Model.Departement;
import Model.Equipe;
import Persistence.AbstractPersistence;


public class Main {

//	public static void main(String[] args) {
//
//		AbstractPersistence<Departement> o = 
//				new AbstractPersistence<Departement>(Departement.class);
//		o.setUp();
//		o.ouvrirSession();// U1
//		Departement d = o.read("Informatique");
//		System.out.println(d.getNom());
//		d.setTelephone("123-456-7890");
//		o.update(d);

//		for (Commande cm : c.getCommandes()) {
//			System.out.println(cm.getQty());
//		}
//
//		o.fermerSession();
//
//		o.ouvrirSession(); // U2
//		c = o.read("c001");
//		System.out.println(c.getNom());
//		o.fermerSession();
//
//		o.ouvrirSession(); // U2
//		List<Client> cls = o.read();
//		for (Client client : cls) {
//			System.out.println(client.getNom());
//		}
//		o.fermerSession();
//		o.close();
//	}
	
	public static void main(String[] args) {
		final int numero = 4;
		switch(numero) {
		case 1: {
			AbstractPersistence<Departement> pManager = 
					new AbstractPersistence<Departement>(Departement.class);
			pManager.setUp();
			pManager.ouvrirSession();
			Departement d = pManager.read("Informatique");
			System.out.println(d);
			pManager.fermerSession();
			pManager.close();
			break;
		} 
		case 2:
		case 3: {
			AbstractPersistence<Chercheur> cManager = 
					new AbstractPersistence<Chercheur>(Chercheur.class);
			cManager.setUp();
			cManager.ouvrirSession();
			List<Chercheur> chercheurs = cManager.read();
			for (Chercheur chercheur : chercheurs) {
				if(!chercheur.getArticles().isEmpty()) {
					System.out.println(chercheur);
					if(numero == 3) {
						for(Article article : chercheur.getArticles()) {
							System.out.println(article);
						}
					}
				}
			}
			cManager.fermerSession();
			cManager.close();
			break;
		}
		case 4:{
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
		/*case 5:
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
			// Je ferme la connection /!\ IMPORTANT /!\ Sinon memory leak
			dManager.close();
			break;
		}
		case 8: {
			PGeneric<Chercheur> cManager = new PGeneric<Chercheur>(Chercheur.class);
			// Connecte a la table Postgres
			cManager.setUp();
			cManager.beginTransaction();
			List<Chercheur> chercheurs = cManager.get("Chercheur");
			for(Chercheur chercheur : chercheurs) {
				if(chercheur.getPosition().equalsIgnoreCase("postdoc") 
					&& chercheur.getEquipe().getDepartement().getNom().equalsIgnoreCase("Physique")) { // Il y a personne en Maths au postdoc :
					chercheur.setPosition("maitrise");
				}
			}
			cManager.commitTransaction();
			cManager.close();
			break;
		}

		case 9: {
			PGeneric<Departement> dManager = new PGeneric<Departement>(Departement.class);
			// Connecte a la table Postgres
			dManager.setUp();

			Departement departement = new Departement();
			departement.setNom("Medecine");
			departement.setDateCreation(LocalDate.of(2018, 03, 01));
			departement.setAdresse("Gaspesie");

			dManager.add(departement);

			dManager.close();
			break;
		}

		case 10: {
			PGeneric<Equipe> eManager = new PGeneric<Equipe>(Equipe.class);
			PGeneric<Departement> dManager = new PGeneric<Departement>(Departement.class);
			eManager.setUp();
			dManager.setUp();
			
			Equipe equipe = new Equipe();
			equipe.setNom("Pediatre");
			
			Departement medecine = dManager.read("Medecine");
			equipe.setDepartement(medecine);

			eManager.add(equipe);
			
			eManager.close();
			dManager.close();
			break;
		}*/


		}
	}

}
