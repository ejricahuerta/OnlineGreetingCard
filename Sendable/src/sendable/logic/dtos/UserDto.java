package sendable.logic.dtos;

import java.util.List;

public class UserDto {

	int Id;
	String FullName;
	String Email;
	String Phone;
	String HashedPassword;
	String CurrentAddress;
	AccountDto AccountDto;
	String DateAdded;
	List<CardLetterDto> CardLetters;
	List<PaymentDto> Payments;

	/**
	 * @param id
	 * @param fullName
	 * @param email
	 * @param hashedPassword
	 * @param currentAddress
	 * @param cardLetterDto
	 * @param accountDto
	 * @param dateAdded
	 * @param payments
	 */
	public UserDto(int id, String fullName, String email, String hashedPassword, String phone, String currentAddress,
			List<CardLetterDto> cardLetters, AccountDto accountDto, String dateAdded, List<PaymentDto> payments) {
		super();
		Id = id;
		FullName = fullName;
		Email = email;
		HashedPassword = hashedPassword;
		CurrentAddress = currentAddress;
		Phone = phone;
		CardLetters = cardLetters;
		AccountDto = accountDto;
		DateAdded = dateAdded;
		Payments = payments;
	}

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getHashedPassword() {
		return HashedPassword;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public void setHashedPassword(String hashedPassword) {
		HashedPassword = hashedPassword;
	}

	public String getCurrentAddress() {
		return CurrentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		CurrentAddress = currentAddress;
	}

	public AccountDto getAccountDto() {
		return AccountDto;
	}

	public void setAccountDto(AccountDto accountDto) {
		AccountDto = accountDto;
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}

	public List<PaymentDto> getPayments() {
		return Payments;
	}

	public void setPayments(List<PaymentDto> payments) {
		Payments = payments;
	}

	public List<CardLetterDto> getCardLetters() {
		return CardLetters;
	}

	public void setCardLetters(List<CardLetterDto> cardLetters) {
		CardLetters = cardLetters;
	}
}
