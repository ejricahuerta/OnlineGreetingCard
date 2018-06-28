package sendable.logic.dtos;

public class CardLetterDto {
	int Id;
	UserDto UserDto;
	CardDto CardDto;
	String Message;
	String FontStyle;
	String DateAdded;

	public CardLetterDto(int id, UserDto userDto, CardDto cardDto,
			String message, String fontStyle, String dateAdded) {
		super();
		Id = id;
		UserDto = userDto;
		CardDto = cardDto;
		Message = message;
		FontStyle = fontStyle;
		DateAdded = dateAdded;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public UserDto getUserDto() {
		return UserDto;
	}
	public void setUserDto(UserDto userDto) {
		UserDto = userDto;
	}
	public CardDto getCardDto() {
		return CardDto;
	}
	public void setCardDto(CardDto cardDto) {
		CardDto = cardDto;
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
		
}
