package sendable.logic.dtos;

public class AccountDto {
	int Id;
	int UserId;
	double Credit;
	String LastTopUpDate;

	public AccountDto(int id, int userId, double credit, String lastTopUpDate) {
		Id = id;
		UserId = userId;
		Credit = credit;
		LastTopUpDate = lastTopUpDate;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int UserId) {
		this.UserId = UserId;
	}

	public double getCredit() {
		return Credit;
	}

	public void setCredit(double credit) {
		Credit = credit;
	}

	public String getLastTopUpDate() {
		return LastTopUpDate;
	}

	public void setLastTopUpDate(String lastTopUpDate) {
		LastTopUpDate = lastTopUpDate;
	}

}
