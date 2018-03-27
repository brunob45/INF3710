package Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Customers;

public class PCustomers {

	private static EntityManagerFactory managerFactory = null;
	private static EntityManager manager = null;

	public void setUp () {
		if (managerFactory == null) {
			managerFactory = Persistence.
					createEntityManagerFactory("CAPO");
		}
		if (manager == null) {
			manager = managerFactory.createEntityManager();
		}
	}

	public Customers read (String id) {
		return manager.find(Customers.class, id);
	}
	
	
	
	public void close() {
		manager.close();
		managerFactory.close();
	}

}
