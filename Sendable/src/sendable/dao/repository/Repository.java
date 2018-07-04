package sendable.dao.repository;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sendable.dao.database.DatabaseManager;

@SuppressWarnings("rawtypes")

public class Repository<T> implements RepositoryInterface<T>, EntityInterface {

	private Class clazz;
	private ArrayList<T> AllList = new ArrayList<T>();
	private EntityManager manager;
	private EntityManagerFactory ef;

	public Repository(Class clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> ListAll() {

		try {

			AllList = (ArrayList<T>) this.GetEntityManager()
					.createQuery("select u from " + clazz.getSimpleName() + " u").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		manager = null;
		return AllList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T Get(int id) {
		try {

			return (T) this.GetEntityManager().find(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return null;
	}

	@Override
	public void Insert(T obj) {
		try {

			this.GetEntityManager().persist(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}

		manager.close();
		manager = null;

	}

	@Override
	public T Find(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void Remove(int id) {
		try {

			T obj = (T) this.GetEntityManager().find(clazz, id);
			manager.remove(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.Commit();

	}

	@Override
	public void Update(T obj) {
		try {
			this.GetEntityManager().merge(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.Commit();
		this.Close();
		manager = null;
	}

	@Override
	public EntityManager GetEntityManager() {
		if (manager == null) {

			ef = Persistence.createEntityManagerFactory("sendable_hibernate");
			manager = ef.createEntityManager();
			manager.getTransaction().begin();
		}
		return manager;
	}

	@Override
	public void Close() {
		manager.close();
		ef.close();
		ef = null;
		manager = null;

	}

	@Override
	public void Commit() {
		manager.getTransaction().commit();

	}
}
