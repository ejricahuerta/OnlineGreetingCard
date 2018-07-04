package sendable.dao.repository;

import javax.persistence.EntityManager;

import sendable.dao.entities.Account;
import sendable.dao.entities.Address;
import sendable.dao.entities.Card;
import sendable.dao.entities.CardLetter;
import sendable.dao.entities.Category;
import sendable.dao.entities.Payment;
import sendable.dao.entities.User;

public class UnitOfWork implements UnitOfWorkInterface {

	RepositoryInterface<Card> card;
	RepositoryInterface<CardLetter> letter;
	RepositoryInterface<User> user;
	RepositoryInterface<Payment> payment;
	RepositoryInterface<Address> address;
	RepositoryInterface<Account> account;
	RepositoryInterface<Category> category;

	@Override
	public RepositoryInterface<Card> GetCardRepo() {
		if (card == null) {

			card = new Repository<Card>(Card.class);
		}
		return card;
	}

	@Override
	public RepositoryInterface<CardLetter> GetCardLetterRepo() {
		if (letter == null) {

			letter = new Repository<CardLetter>(CardLetter.class);
		}
		return letter;
	}

	@Override
	public RepositoryInterface<User> GetUserRepo() {
		if (user == null) {
			user = new Repository<User>(User.class);
		}
		return user;
	}

	@Override
	public RepositoryInterface<Payment> GetPaymentRepo() {
		if (payment == null) {

			payment = new Repository<Payment>(Payment.class);
		}
		return payment;
	}

	@Override
	public RepositoryInterface<Address> GetAddressRepo() {
		if (address == null) {

			address = new Repository<Address>(Address.class);
		}
		return address;
	}

	@Override
	public RepositoryInterface<Account> GetAccountRepo() {
		if (account == null) {
			account = new Repository<Account>(Account.class);
		}
		return account;
	}

	@Override
	public RepositoryInterface<Category> GetCategoryRepo() {
		if (category == null) {
			category = new Repository<Category>(Category.class);
		}
		return null;
	}

	
}
