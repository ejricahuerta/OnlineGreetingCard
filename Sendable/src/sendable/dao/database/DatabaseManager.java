package sendable.dao.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

import sendable.dao.entities.Category;
import sendable.dao.interfaces.DatabaseManagerInterface;
import sendable.dao.interfaces.UnitOfWorkInterface;
import sendable.dao.repository.UnitOfWork;

public class DatabaseManager implements DatabaseManagerInterface {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;

	public EntityManager getEntityManager() {
		if (this.entityManager == null) {
			if (this.entityManagerFactory == null) {
				this.entityManagerFactory = Persistence.createEntityManagerFactory("sendable_hibernate");
			}
			this.setEntityManager(this.entityManagerFactory.createEntityManager());
		}
		if (!this.entityManager.getTransaction().isActive()) {
			this.entityManager.getTransaction().begin();
		}
		return entityManager;
	}

	private void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public DatabaseManager() {
	}

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
	public void Save() {
		this.getEntityManager().getTransaction().commit();
	}

	@Override
	public void RollBack() {
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
		this.entityManagerFactory = null;
	}

	@Override
	public void Finished() {
		this.entityManager.close();
		this.entityManager = null;
	}

}
