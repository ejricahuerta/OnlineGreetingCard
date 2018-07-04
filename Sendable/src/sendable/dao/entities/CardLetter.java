package sendable.dao.entities;

public class CardLetter extends BaseEntity {
	
	int UserId;
	int CardId;
	User User;
	Card Card;
	String Message;
	String FontStyle;
	double TotalCost;
	String DateAdded;
	String Status;
	String DateSent;

	public CardLetter(int id, int userId ,int cardId, String message, String font,double totalCost, String dateAdded) {
		super(id);
		UserId = userId;
		this.CardId = cardId;
		this.Message = message;
		this.FontStyle = font;
		this.setTotalCost(totalCost);
		DateAdded = DateTime.GetCurrentDate();
		this.Status = "Pending";
	}
	
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}



	public int getCardId() {
		return this.CardId;
	}
	
	public void setCard(int cardId) {
		this.CardId = cardId;
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



	public void setCardId(int cardId) {
		CardId = cardId;
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


	public void sendLetter(){
		this.Status = "Sent";
		this.DateSent = DateTime.GetCurrentDate();
	}
	
}
