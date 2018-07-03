package sendable.dao.repository;



import java.util.List;

public interface RepositoryInterface<T> {

	List<T> ListAll();
	
	T Get(int id);
	
	void Insert(T obj);
	
	void Update(T obj);
	
	T Find(String query);
	
	void Remove(int id);

}
