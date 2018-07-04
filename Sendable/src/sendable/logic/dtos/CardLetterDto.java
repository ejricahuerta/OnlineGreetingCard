package sendable.logic.dtos;

public class CardLetterDto {
	int Id;
	int UserId;
	int CardId;
	String Message;
	String FontStyle;
	double TotalCost;
	String DateAdded;

	/**
	 * @param id
	 * @param userId
	 * @param cardId
	 * @param message
	 * @param fontStyle
	 * @param totalCost
	 * @param dateAdded
	 */
	public CardLetterDto(int id, int userId, int cardId, String message, String fontStyle, double totalCost,
			String dateAdded) {
		super();
		Id = id;
		UserId = userId;
		CardId = cardId;
		Message = message;
		FontStyle = fontStyle;
		TotalCost = totalCost;
		DateAdded = dateAdded;
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

}
