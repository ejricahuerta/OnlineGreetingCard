package sendable.dao.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {
	
	static EntityManagerFactory ef;
	
	//Always close after calling this method
	public static EntityManager getEntityManager() {
		if( ef == null) {
			ef =  Persistence.createEntityManagerFactory("sendable_hibernate");
		}
		return ((EntityManager) ef.createEntityManager());
	}
}
