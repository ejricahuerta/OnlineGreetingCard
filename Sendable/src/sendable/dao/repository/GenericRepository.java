package sendable.dao.repository;

import java.util.ArrayList;
import java.util.List;

import sendable.dao.entities.BaseEntity;

public class GenericRepository
implements RepositoryInterface<BaseEntity>
{

	@Override
	public ArrayList<BaseEntity> ListAll() {
		// TODO Auto-generated method stub
		return new ArrayList<BaseEntity>();
	}

	@Override
	public BaseEntity Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(BaseEntity obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseEntity Find(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Remove(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
