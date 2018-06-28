package sendable.dao.repository;


import java.util.ArrayList;
import java.util.List;

public interface RepositoryInterface<BaseEntity> {

	ArrayList<BaseEntity> ListAll();
	
	BaseEntity Get(int id);
	
	void Insert(BaseEntity obj);
	
	BaseEntity Find(String query);
	
	void Remove(int id);

}
