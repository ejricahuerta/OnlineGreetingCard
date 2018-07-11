package sendable.logic.interfaces;

import java.util.List;

import sendable.logic.dtos.AccountDto;
import sendable.logic.dtos.AddressDto;
import sendable.logic.dtos.CardLetterDto;
import sendable.logic.dtos.UserDto;

public interface UserInterface {

	void AddNewUser(UserDto user,AddressDto address);
		
	UserDto FindUserById(int id);

	UserDto FindUserByEmail(String email);

	boolean ChangeUserPassword(int userId, String password);

	boolean UpdateUserInfo(int userId, String fname, String lname, String email);

	boolean UpdateUserAddress(int userId, String line1, String line2, String city, String state, String postalcode);

	AccountDto GetUserAccount(int userId);

	boolean TopUpUserAccount(int UserId, double amount);

	CardLetterDto GetUserLetters(int userId, int letterId);

	List<CardLetterDto> GetAllUserLetters(int userId);

	boolean AddUserLetter(int UserId, CardLetterDto letter);

	boolean RemoveUserLetter(int userId, int letterId);
	
	boolean ValidateLogin(String email, String password);
	
	boolean IsUserFound(String email);

	void SaveChanges();
}
