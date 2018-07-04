package sendable.dao.repository;

import java.util.*;

import javax.persistence.EntityManager;

import sendable.dao.database.DatabaseManager;

@SuppressWarnings("rawtypes")

public class Repository<T> implements RepositoryInterface<T> {

	private EntityManager manager;
	private Class clazz;
	private ArrayList<T> AllList = null;

	public Repository(Class clazz) {
		this.clazz = clazz;
		manager = DatabaseManager.getEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> ListAll() {

		try {
			manager.getTransaction().begin();
			AllList = (ArrayList<T>) manager.createQuery("select u from " + clazz.getSimpleName() + " u")
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return AllList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T Get(int id) {
		try {
			return (T) manager.find(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void Insert(T obj) {
		try {
			manager.persist(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			T obj = (T) manager.find(clazz, id);
			manager.remove(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void Update(T obj) {
		try {
			manager.merge(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
