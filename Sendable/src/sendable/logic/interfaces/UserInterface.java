package sendable.logic.interfaces;


import sendable.logic.dtos.CardLetterDto;
import sendable.logic.dtos.UserDto;

public interface UserInterface {
	
	UserDto FindUserById(int id);
	
	UserDto FindUSerByEmail(String email);
	
	boolean ChangeUserPassword(int userId, String password);
	
	boolean UpdateUserInfo(int userId, String fname, String lname, String email);
	
	boolean UpdateUserAddress(int userId, 
			String line1, String line2,
			String city, String state,
			String postalcode);
	
	boolean TopUpUserAccount(int UserId, double amount);
	
	boolean AddUserLetter(int UserId, CardLetterDto letter);
	
	boolean RemoveUserLetter(int userId, int letterId);
	
}
