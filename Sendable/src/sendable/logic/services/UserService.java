package sendable.logic.services;

import java.util.ArrayList;
import java.util.List;

import sendable.dao.entities.*;
import sendable.dao.repository.RepositoryInterface;
import sendable.dao.repository.UnitOfWork;
import sendable.logic.dtos.*;
import sendable.logic.interfaces.UserInterface;

public class UserService implements UserInterface {

	private RepositoryInterface<User> userRepository;
	private RepositoryInterface<CardLetter> cardletterRepository;
	private RepositoryInterface<Card> cardRepository;
	private RepositoryInterface<Account> accountRepository;
	private RepositoryInterface<Payment> paymentRepository;
	private RepositoryInterface<Address> addressRepository;
	
	private UnitOfWork unit;

	
	
	private ArrayList<UserDto> AllUsers;

	public UserService(UnitOfWork work) {
		unit  = work;
	}
	
	public UserService(RepositoryInterface<User> userrepo, RepositoryInterface<CardLetter> cardletterrepo,
			RepositoryInterface<Card> cardrepo, RepositoryInterface<Account> accountrepo,
			RepositoryInterface<Payment> paymentrepo, RepositoryInterface<Address> addressrepo) {
		this.userRepository = userrepo;
		this.cardletterRepository = cardletterrepo;
		this.cardRepository = cardrepo;
		this.accountRepository = accountrepo;
		this.paymentRepository = paymentrepo;
		this.addressRepository = addressrepo;

	}

	public void Init() {
		this.AllUsers = new ArrayList<UserDto>();

		this.userRepository.ListAll().forEach(u -> {
			this.AllUsers.add(this.MapUser(u));
		});
	}

	@Override
	public UserDto FindUserById(int id) {
		return this.MapUser(this.userRepository.Get(id));
	}

	@Override
	public UserDto FindUSerByEmail(String email) {
		for (UserDto userDto : AllUsers) {
			if (userDto.getEmail().equals(email)) {
				return userDto;
			}
		}
		return null;
	}

	@Override
	public boolean ChangeUserPassword(int userId, String password) {
		try {
			AllUsers.forEach(u -> {
				if (u.getId() == userId) {
					u.setHashedPassword(password);
					// Updating User
					User user = this.userRepository.Get(userId);
					user.setPassword(password);
					this.userRepository.Update(user);
				}
			});

			return true;
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean UpdateUserInfo(int userId, String fname, String lname, String email) {

		try {
			AllUsers.forEach(u -> {
				if (u.getId() == userId) {
					u.setFullName(String.format("%s %s", fname, lname));
					u.setEmail(email);

					User user = this.userRepository.Get(userId);
					user.setFullName(fname, lname);
					user.setEmail(email);
					this.userRepository.Update(user);
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean UpdateUserAddress(int userId, String line1, String line2, String city, String state,
			String postalcode) {

		try {
			AllUsers.forEach(u -> {
				if (u.getId() == userId) {
					String address = null;
					if (line2.isEmpty()) {
						address = String.format("%s %s %s %s", line1, city, state, postalcode);
					} else {
						address = String.format("%s %s %s %s", line1, city, state, postalcode);
					}
					u.setCurrentAddress(address);
					User user = this.userRepository.Get(userId);
					Address useraddress = addressRepository.Get(user.getCurrentAddress().getId());
					useraddress.Update(line1, line2, city, state, postalcode);
					this.addressRepository.Update(useraddress);
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean TopUpUserAccount(int UserId, double amount) {
		try {
			AllUsers.forEach(u -> {
				if (u.getId() == UserId) {
					u.getAccountDto().setCredit(amount);

					// Update Account
					Account account = accountRepository.Get(u.getAccountDto().getId());
					accountRepository.Update(account);
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean AddUserLetter(int UserId, CardLetterDto letter) {
		try {
			AllUsers.forEach(u -> {
				if (u.getId() == UserId) {
					u.getCardLetters().add(letter);

					// add new card
					User userLetter = this.userRepository.Get(UserId);
					Card card = this.cardRepository.Get(letter.getCardId());
					this.cardletterRepository.Insert(new CardLetter(userLetter, card, letter.getMessage(),
							letter.getFontStyle(), letter.getTotalCost(), letter.getDateAdded()));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean RemoveUserLetter(int userId, int letterId) {
		try {
			AllUsers.forEach(u -> {
				u.getCardLetters().removeIf(l -> l.getId() == letterId);
			});

			this.cardletterRepository.Remove(letterId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private UserDto MapUser(User user) {
		if (user == null) {
			return null;
		} else {
			// Mapping all data to DTOs;
			ArrayList<CardLetterDto> cardletters = new ArrayList<CardLetterDto>();

			// get all cards where user id == userId
			this.cardletterRepository.ListAll().forEach(c -> {
				if (c.getUser() == user) {
					cardletters.add(new CardLetterDto(c.getId(), c.getUser().getId(), c.getCard().getId(),
							c.getMessage(), c.getFont(), c.getTotalCost(), c.getDateAdded()));
				}
			});

			// get account from database
			Account account = this.accountRepository.Get(user.getAccount().getId());

			// user account mapping
			AccountDto accountdto = new AccountDto(account.getId(), account.getUser().getId(), account.getCredit(),
					account.getLastTopUpDate());

			List<PaymentDto> allpayments = new ArrayList<PaymentDto>();
			this.paymentRepository.ListAll().forEach(p -> {
				if (p.getUser() == user) {

					// user payment mapping
					allpayments.add(new PaymentDto(p.getId(), p.getUser().getId(), p.getCardLetter().getId(),
							p.getBillingAddress().GetAddressString(), p.getShippingAddress().GetAddressString(),
							p.getPaymentType(), p.getDateAdded(), p.getTotalAmount()));
				}
			});

			for (Address address : this.addressRepository.ListAll()) {
				if (address.getId() == user.getCurrentAddress().getId()) {
					user.setAddress(address);
					break;
				}
			}

			// User Dto Mapping
			UserDto userdto = new UserDto(user.getId(), user.getFullName(), user.getEmail(), user.getPassword(),
					user.getPhone(), user.getCurrentAddressString(), cardletters, accountdto, user.getDateAdded(),
					allpayments);
			return userdto;
		}
	}

	@Override
	public AccountDto GetUserAccount(int userId) {
		for (UserDto userDto : AllUsers) {
			if (userDto.getId() == userId) {
				return userDto.getAccountDto();
			}
		}
		return null;
	}

	@Override
	public CardLetterDto GetUserLetters(int userId, int letterId) {
		for (CardLetterDto letter : this.GetAllUserLetters(userId)) {
			if (letter.getId() == letterId) {
				return letter;
			}
		}
		return null;
	}

	@Override
	public List<CardLetterDto> GetAllUserLetters(int userId) {
		try {
			for (UserDto userDto : AllUsers) {
				if (userDto.getId() == userId) {
					return userDto.getCardLetters();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
