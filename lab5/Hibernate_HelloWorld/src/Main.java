//import java.util.List;

//import Model.Article;
//import Model.Chercheur;
import Model.Article;
import Model.Departement;
//import Model.Equipe;
import Persistence.AbstractPersistence;
//import Persistence.PDepartement;

public class Main {

	public static void main(String[] args) {

		AbstractPersistence<Article> o = 
				new AbstractPersistence<Article>(Article.class);
		o.setUp();
		o.ouvrirSession();// U1
		Article d = o.read("Informatique");
		System.out.println(d.getAuteur());
//		d.setTelephone("123-456-7890");
//		o.update(d);

		/*for (Commande cm : c.getCommandes()) {
			System.out.println(cm.getQty());
		}

		o.fermerSession();

		o.ouvrirSession(); // U2
		c = o.read("c001");
		System.out.println(c.getNom());
		o.fermerSession();

		o.ouvrirSession(); // U2
		List<Client> cls = o.read();
		for (Client client : cls) {
			System.out.println(client.getNom());
		}*/


		o.fermerSession();





		o.close();




	}

}
