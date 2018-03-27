import Model.Customers;
import Model.Orders;
import Persistence.PCustomers;

public class Main {

	public static void main(String[] args) {
		PCustomers c = new PCustomers();
		c.setUp();
		Customers client = c.read("c001");
		System.out.println(client);
		for (Orders order : client.getCommandes()) {
			System.out.println(order.getDollars());
		}
		c.close();
	}
}
