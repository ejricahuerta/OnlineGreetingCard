package sendable.dao.entities;

public class CardLetter extends BaseEntity {
	
	int UserId;
	Card Card;
	String Message;
	String FontStyle;
	String DateAdded;

	public CardLetter(int userId ,Card card, String message, String font) {
		super(0);
		
		UserId = userId;
		this.Card = card;
		this.Message = message;
		this.FontStyle = font;
	}
	
	
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}



	public Card getCard() {
		return this.Card;
	}
	
	public void setCard(Card card) {
		this.Card = card;
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
}
