package sendable.dao.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.catalina.User;

public class DatabaseManager {
	
	public static void main(String[] args) {
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("sendable_hibernate");
		EntityManager manager =  emf.createEntityManager();
		manager.getTransaction().begin();
		SeedDatabase seed = new SeedDatabase();
		
		seed.AddUsers().forEach(u-> {
			System.out.println(u.getCurrentAddressString());
			manager.persist(u.getCurrentAddress());
			manager.persist(u);
		});
		manager.getTransaction().commit();
		
		manager.close();
		emf.close();
	}
}
