package sendable.dao.entities;

public class BaseEntity implements EntityInterface{

	public BaseEntity(int id) {
		Id = id;
	}

	private int Id;
	@Override
	public void setId(int id) {
		this.Id = id;
	}

	@Override
	public int getId() {
		return this.Id;
	}

}
