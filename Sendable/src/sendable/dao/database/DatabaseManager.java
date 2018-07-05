package sendable.dao.database;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

public class DatabaseManager implements DatabaseManagerInterface {

	/*
	 * Database Manager Injected with Entity Persistence
	 */
	
	@PersistenceContext(unitName = "sendable_hibernate", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public DatabaseManager() {}
	@Override
	public void Add(Object obj) throws Exception {
		this.entityManager.persist(obj);
	}

	@Override
	public void Remove(Object obj) throws Exception {
		this.entityManager.remove(obj);

	}

	@Override
	public Object Get(Class<?> clazz, int id) throws Exception {
		return this.entityManager.find(clazz, id);
	}

	@Override
	public void Save() throws Exception {
		this.entityManager.getTransaction().commit();
		
	}

	@Override
	public void RollBack() throws Exception {
		this.entityManager.getTransaction().rollback();

	}

	@Override
	public Query ExecuteQuery(String query) throws Exception {
		return this.entityManager.createQuery(query);
	}
	@Override
	public void Update(Object obj) throws Exception {
		this.entityManager.merge(obj);
		
	}

}
