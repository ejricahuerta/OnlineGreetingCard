package sendable.dao.repository;

import java.util.*;

public class Repository<T> implements RepositoryInterface<T> 
{
	@SuppressWarnings("unused")
	private Class<?> clazz;
	
	public Repository(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public List<T> ListAll() {
		// TODO Auto-generated method stub
		return new ArrayList<T>();
	}

	@Override
	public T Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T Find(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Remove(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Connect(String connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Commit() {
		// TODO Auto-generated method stub
		
	}
}
