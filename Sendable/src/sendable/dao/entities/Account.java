package sendable.dao.entities;

import javax.persistence.*;

@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;
	double Credit;
	String LastTopUpDate;
	
	@OneToOne
	User User;

	public Account() {}
	
	public Account(User	user, double credit, String lastTopUpDate) {
		this.User = user;
		Credit = credit;
		LastTopUpDate = lastTopUpDate;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public int getId() {
		return this.Id;
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

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}
	

}
