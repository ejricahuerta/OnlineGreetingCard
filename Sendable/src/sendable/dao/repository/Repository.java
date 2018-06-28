package sendable.dao.repository;

import java.util.*;

import sendable.dao.entities.BaseEntity;

public class Repository<T extends BaseEntity> implements RepositoryInterface<T> 
{
	private Class<T> clazz;
	
	public Repository(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public List<T> ListAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(BaseEntity obj) {
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
	
}
