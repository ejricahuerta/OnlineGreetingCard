package sendable.entities;

public class BaseEntity implements EntityInterface{

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
