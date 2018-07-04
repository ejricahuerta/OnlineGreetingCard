package sendable.dao.repository;

import javax.persistence.EntityManager;

public interface EntityInterface {
	
	EntityManager GetEntityManager();
	
	void Close();

	void Commit();
}
