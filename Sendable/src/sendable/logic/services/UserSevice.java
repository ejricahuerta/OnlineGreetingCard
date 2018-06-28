package sendable.logic.services;

import sendable.dao.entities.User;
import sendable.dao.repository.RepositoryInterface;
import sendable.logic.dtos.CardLetterDto;
import sendable.logic.dtos.UserDto;
import sendable.logic.interfaces.UserInterface;

public class UserSevice implements UserInterface{


	private RepositoryInterface<User> repository;
	
	public UserSevice(RepositoryInterface<User> repo) {
		this.repository  = repo;
	}
	@Override
	public UserDto FindUserById(int id) {
		// TODO Auto-generated method stub
		User user = repository.Get(id);
		UserDto dto= new UserDto(
				""
				);
		return dto;
	}
	@Override
	public UserDto FindUSerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean ChangeUserPassword(int userId, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean UpdateUserInfo(int userId, String fname, String lname, String email) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean UpdateUserAddress(int userId, String line1, String line2, String city, String state,
			String postalcode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean TopUpUserAccount(int UserId, double amount) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean AddUserLetter(int UserId, CardLetterDto letter) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean RemoveUserLetter(int userId, int letterId) {
		// TODO Auto-generated method stub
		return false;
	}

}
