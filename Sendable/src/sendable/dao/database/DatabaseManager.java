package sendable.dao.database;

public class DatabaseManager {
	public String GetAll(String table) {
		return String.format("Select * from %s;", table);	
	}
	
	public String Get(String table, int id) {
		return String.format("Select * from %s where id=%d", table,id);
	}

}
