package sendable.dao.repository;

import java.util.*;
import sendable.dao.interfaces.DatabaseManagerInterface;
import sendable.dao.interfaces.RepositoryInterface;

@SuppressWarnings("rawtypes")

public class Repository<T> implements RepositoryInterface<T> {

	private DatabaseManagerInterface db;
	private Class clazz;
	public Repository(Class clazz, DatabaseManagerInterface db) {
		this.clazz = clazz;
		this.db = db;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> ListAll() {
		try {
			String query = "select u from " + clazz.getSimpleName() + " u";
			List ret = 	this.db.ExecuteQuery(query).getResultList();
			//db.Finished();
			return ret;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T Get(int id){
		try {

			return	(T) this.db.Get(clazz, id);
		} catch (Exception e) {
			db.RollBack();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void Insert(T obj) {
		try {

			this.db.Add(obj);

		} catch (Exception e) {
			db.RollBack();
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

			T obj = (T) this.db.Get(clazz, id);
			db.Remove(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update(T obj) {
		try {
			this.db.Update(obj);
		} catch (Exception e) {
			db.RollBack();
			e.printStackTrace();
		}
	}
	
	
}
