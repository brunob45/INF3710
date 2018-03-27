package Persistence;

import java.beans.Customizer;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Model.Commande;

public class PCommande {
	private SessionFactory sessionFactory = null;
	private Session currentSession = null;

	public void setUp () {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try { 
			sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
		} catch (Exception ex) { 
			StandardServiceRegistryBuilder.destroy(registry); 
		}

	}

	public void ouvrirSession() {
		try {
			currentSession = sessionFactory.openSession();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Commande read(int id) {
		return currentSession.find(Commande.class, id);
	}

	public List<Commande> read() {
		return currentSession.createQuery("from " + Commande.class.getName()).getResultList();
	}

	public void update (Commande c) {
		Transaction tx = currentSession.getTransaction();
		try {
			tx.begin();
			currentSession.update(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

	public void fermerSession() {
		/* Instructions … */
		currentSession .close();

	}
	public void close() {
		sessionFactory.close();
	}

}
