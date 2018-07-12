package sendable.logic.interfaces;

import java.util.List;

import sendable.logic.dtos.AccountDto;
import sendable.logic.dtos.AddressDto;
import sendable.logic.dtos.CardLetterDto;
import sendable.logic.dtos.UserDto;

public interface UserInterface {

	void addNewUser(UserDto user,AddressDto address);
		
	UserDto findUserById(int id);

	UserDto findUserByEmail(String email);

	boolean changeUserPassword(int userId, String password);

	boolean updateUserInfo(int userId, String fname, String lname, String email, String phone);

	boolean updateUserAddress(int userId, String line1, String line2, String city, String state, String postalcode);

	AccountDto getUserAccount(int userId);

	boolean topUpUserAccount(int UserId, double amount);

	CardLetterDto getUserLetter(int userId, int letterId);

	List<CardLetterDto> getAllUserLetters(int userId);

	int addUserLetter(int UserId, CardLetterDto letter);
	boolean updateUserLetter(int UserId, CardLetterDto letter);

	boolean removeUserLetter(int userId, int letterId);
	
	boolean validateLogin(String email, String password);
	
	boolean isUserFound(String email);

	void saveChanges();
}
