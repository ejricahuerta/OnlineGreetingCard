package sendable.dao.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sendable.dao.entities.Category;
import sendable.dao.entities.DateTime;
import sendable.dao.interfaces.DatabaseManagerInterface;

public class DatabaseManager implements DatabaseManagerInterface {

	/*
	 * Database Manager Injected with Entity Persistence
	 */
	
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManager getEntityManager() {
		if(this.entityManagerFactory == null && this.entityManager == null) {
			this.entityManagerFactory = Persistence.createEntityManagerFactory("sendable_hibernate");
			this.setEntityManager(this.entityManagerFactory.createEntityManager());
			this.entityManager.getTransaction().begin();
		}
		return entityManager;
	}
	private void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public DatabaseManager() {}
	@Override
	public void Add(Object obj) throws Exception {
		this.getEntityManager().persist(obj);
	}

	@Override
	public void Remove(Object obj) throws Exception {
		this.entityManager.remove(obj);
	}

	@Override
	public Object Get(Class<?> clazz, int id) throws Exception {
		return this.getEntityManager().find(clazz, id);
	}

	@Override
	public void Save() throws Exception {
		this.getEntityManager().getTransaction().commit();
		this.entityManager.close();
		
	}

	@Override
	public void RollBack() throws Exception {
		this.getEntityManager().getTransaction().rollback();
		this.entityManager.close();
	}

	@Override
	public Query ExecuteQuery(String query) throws Exception {
		return this.getEntityManager().createQuery(query);
	}
	@Override
	public void Update(Object obj) throws Exception {
		this.getEntityManager().merge(obj);
		
	}
	
	@Override
	public void Close() {
		this.entityManagerFactory.close();
	}
	
	public static void main(String[] args){
		DatabaseManager db = new DatabaseManager();
		
		try {
			db.Add(new Category("Birthdays", "Sample data", DateTime.GetCurrentDate()));
			db.Save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
