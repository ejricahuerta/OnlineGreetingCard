package sendable.dao.repository;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sendable.dao.database.DatabaseManager;

@SuppressWarnings("rawtypes")

public class Repository<T> implements RepositoryInterface<T> {

	private Class clazz;
	private ArrayList<T> AllList = new ArrayList<T>();
	private EntityManager manager;
	public Repository(Class clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> ListAll() {

		try {
			 manager = this.getEntityManager();
			 manager.getTransaction().begin();
			AllList = (ArrayList<T>) manager.createQuery("select u from " + clazz.getSimpleName() + " u")
					.getResultList();
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
			manager = this.getEntityManager();
			manager.getTransaction().begin();
			return (T) manager.find(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return null;
	}

	@Override
	public void Insert(T obj) {
		try {
			manager = this.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(obj);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		manager  = null;
		
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
			manager = this.getEntityManager();
			manager.getTransaction().begin();
			T obj = (T) this.manager.find(clazz, id);
			manager.remove(obj);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		manager  = null;

	}

	@Override
	public void Update(T obj) {
		try {
			manager = this.getEntityManager();
			manager.getTransaction().begin();
			
			manager.merge(obj);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		manager = null;
	}

	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sendable_hibernate");
		return ((EntityManager) emf.createEntityManager());
	}

//	public static void main(String[] args) {
//		RepositoryInterface<User> user = new Repository<User>(User.class);
//
//		for (User u : user.ListAll()) {
//			System.out.println(u.getEmail());
//		}
//		System.out.println("End..");
//		
//		
//
//	}
}
