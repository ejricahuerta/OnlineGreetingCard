package sendable.dao.interfaces;

import sendable.dao.entities.Account;
import sendable.dao.entities.Address;
import sendable.dao.entities.Card;
import sendable.dao.entities.CardLetter;
import sendable.dao.entities.Category;
import sendable.dao.entities.Payment;
import sendable.dao.entities.User;

public interface UnitOfWorkInterface {

	RepositoryInterface<CardLetter> GetCardLetterRepo();
	
	RepositoryInterface<Card> GetCardRepo();
	
	RepositoryInterface<Category> GetCategoryRepo();
	
	RepositoryInterface<User> GetUserRepo();
	
	RepositoryInterface<Payment> GetPaymentRepo();
	
	RepositoryInterface<Address> GetAddressRepo();
	
	RepositoryInterface<Account> GetAccountRepo();
	
	void Save();
	
	void Close();
}