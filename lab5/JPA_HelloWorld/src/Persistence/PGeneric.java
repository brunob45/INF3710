package Persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Departement;

public class PGeneric<T> {

	final Class<T> klass;
	
	public PGeneric(Class<T> klass) {
		this.klass = klass;
	}
	
	private static EntityManagerFactory managerFactory = null;
	private static EntityManager manager = null;

	public void setUp () {
		if (managerFactory == null) {
			managerFactory = Persistence.
					createEntityManagerFactory("tp5");
		}
		if (manager == null) {
			manager = managerFactory.createEntityManager();
		}
	}

	public T read (String nom) {
		return manager.find(klass, nom);
	}
	
	public List<T> get(String table) {
		TypedQuery<T> q = manager.createQuery("SELECT t FROM "+table+" t", klass);
		return q.getResultList();
	}
	
	public void remove(T item) {
		beginTransaction();
		manager.remove(item);
		commitTransaction();
	}
	
	public void beginTransaction() {
		manager.getTransaction().begin();
	}
	
	public void commitTransaction() {
		manager.getTransaction().commit();
	}
	
	public void close() {
		manager.close();
		managerFactory.close();
	}

}
