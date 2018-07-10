package sendable.logic.dtos;

public class CardLetterDto {
	int Id;
	int UserId;
	int CardId;
	String ImageURL;
	String Recipient;
	String Message;
	String FontStyle;
	double TotalCost;
	String DateAdded;
	String Status;
	/**
	 * @param id
	 * @param userId
	 * @param cardId
	 * @param message
	 * @param fontStyle
	 * @param totalCost
	 * @param dateAdded
	 */
	public CardLetterDto(int id, int userId, int cardId,String recipient, String message, String fontStyle, double totalCost,
			String dateAdded) {
		Id = id;
		UserId = userId;
		CardId = cardId;
		Recipient = recipient;
		Message = message;
		FontStyle = fontStyle;
		TotalCost = totalCost;
		DateAdded = dateAdded;
		Status = "Pending";
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

	public int getCardId() {
		return CardId;
	}

	public void setCardId(int CardId) {
		this.CardId = CardId;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getFontStyle() {
		return FontStyle;
	}

	public void setFontStyle(String fontStyle) {
		FontStyle = fontStyle;
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

	public void setTotalCost(double totalCost) {
		TotalCost = totalCost;
	}

	public String getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	public String getRecipient() {
		return Recipient;
	}

	public void setRecipient(String recipient) {
		Recipient = recipient;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	

}
