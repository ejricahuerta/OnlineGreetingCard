package sendable.dao.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table
public class CardLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;

	String Recipient;
	String Message;
	String FontStyle;
	double TotalCost;
	String DateAdded;
	String Status;
	String DateSent;

	@ManyToOne(fetch=FetchType.LAZY)
	User User;
	@OneToOne(fetch=FetchType.LAZY)
	Card Card;

	public CardLetter() {
	}

	public CardLetter(User user, Card card,String recipient, String message, String font, double totalCost, String dateAdded) {

		this.User = user;
		this.Card = card;
		this.Recipient = recipient;
		this.Message = message;
		this.FontStyle = font;
		this.setTotalCost(totalCost);
		DateAdded = DateTime.GetCurrentDate();
		this.Status = "Pending";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public Card getCard() {
		return Card;
	}

	public void setCard(Card card) {
		Card = card;
	}

	public String getMessage() {
		return this.Message;
	}

	public void setMessage(String message) {
		this.Message = message;
	}

	public String getFont() {
		return this.FontStyle;
	}

	public void setFont(String font) {
		this.FontStyle = font;
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}

	public double getTotalCost() {
		return TotalCost;
	}

	private void setTotalCost(double totalCost) {
		this.TotalCost = totalCost * 1.13;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDateSent() {
		return DateSent;
	}

	public void setDateSent(String dateSent) {
		DateSent = dateSent;
	}

	public void sendLetter() {
		this.Status = "Sent";
		this.DateSent = DateTime.GetCurrentDate();
	}

	public String getRecipient() {
		return Recipient;
	}

	public void setRecipient(String recipient) {
		Recipient = recipient;
	}
	

}
