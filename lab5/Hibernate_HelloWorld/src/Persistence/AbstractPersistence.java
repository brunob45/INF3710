package Persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class AbstractPersistence<TYPE> {
	private Class<TYPE> clazz;
	
	private static SessionFactory sessionFactory = null;
	private static Session currentSession = null;
	private static Integer instances = 0;
	
	public AbstractPersistence(Class<TYPE> c) {
		this.clazz = c;
	}

	public void setUp () {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try { 
			sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
			instances++;
		} catch(HibernateException exception){
		     System.out.println("\nProblem creating session factory");
		     exception.printStackTrace();
			 StandardServiceRegistryBuilder.destroy(registry); 
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

	public TYPE read(Object id) {
		return currentSession.find(clazz, id);
	}

	public List<TYPE> read() {
		return currentSession.createQuery("from " + clazz.getName()).getResultList();
	}

	public void update (TYPE c) {
		Transaction tx = currentSession.getTransaction();
		try {
			tx.begin();
			currentSession.update(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void remove (TYPE item) {
		Transaction tx = currentSession.getTransaction();
		try {
			tx.begin();
			currentSession.remove(item);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		}
	}
	
	public void add (TYPE item) {
		Transaction tx = currentSession.getTransaction();
		try {
			tx.begin();
			currentSession.persist(item);
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
		instances--;
		if(instances < 0) {
			sessionFactory.close();
		}
	}


}
