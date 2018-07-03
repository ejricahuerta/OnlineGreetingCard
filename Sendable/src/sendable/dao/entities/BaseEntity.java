package sendable.dao.entities;

public abstract class BaseEntity implements EntityInterface{

	private int Id;
	
	public BaseEntity(int id) {
		Id = id;
	}

	@Override
	public void setId(int id) {
		this.Id = id;
	}

	@Override
	public int getId() {
		return this.Id;
	}

}
