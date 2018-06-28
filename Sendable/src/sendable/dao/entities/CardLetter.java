package sendable.dao.entities;

public class CardLetter extends BaseEntity {
	
	int UserId;
	int CardId;
	String Message;
	String FontStyle;
	String DateAdded;

	public CardLetter(int userId ,int cardId, String message, String font) {
		super(0);
		
		UserId = userId;
		this.CardId = cardId;
		this.Message = message;
		this.FontStyle = font;
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
}
