package sendable.logic.dtos;

public class AccountDto {
	int Id;
	UserDto UserDto;
	double Credit;
	String LastTopUpDate;

	public AccountDto(UserDto userDto, double credit, String lastTopUpDate) {
		super();
		UserDto = userDto;
		Credit = credit;
		LastTopUpDate = lastTopUpDate;
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
