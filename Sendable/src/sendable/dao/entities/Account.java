package sendable.dao.entities;


public class Account extends BaseEntity{
	
	int UserId;
	User User;
	double Credit;
	String LastTopUpDate;
	
	public Account(int userId, double credit, String lastTopUpDate) {
		super(0);
		UserId = userId;
		Credit = credit;
		LastTopUpDate = lastTopUpDate;
	}
	public double getCredit() {
		return Credit;
	}
	public void setCredit(double credit) {		
		Credit = credit;
		LastTopUpDate = DateTime.GetCurrentDate();
	}
	public String getLastTopUpDate() {
		return LastTopUpDate;
	}
	public void setLastTopUpDate(String lastTopUpDate) {
		LastTopUpDate = lastTopUpDate;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
}
