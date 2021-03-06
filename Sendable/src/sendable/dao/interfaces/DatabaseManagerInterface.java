package sendable.dao.interfaces;

import javax.persistence.Query;

public interface DatabaseManagerInterface {
	
	/*
	 * Database manager leveraging Persistence EntityManager
	 */ 
	
	void Add(Object obj) throws Exception;
	
	void Remove(Object obj)throws Exception;
	
	void Update(Object obj) throws Exception;
	
	Object Get(Class<?> clazz,int id)throws Exception;;
	
	Query ExecuteQuery(String query)throws Exception;;
	
	void Save();
	
	void RollBack();
	
	void Finished();
	
	void Close();

}
