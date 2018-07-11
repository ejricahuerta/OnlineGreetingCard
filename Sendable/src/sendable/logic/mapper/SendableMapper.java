package sendable.logic.mapper;

import java.util.ArrayList;
import java.util.List;

import sendable.dao.entities.Account;
import sendable.dao.entities.Address;
import sendable.dao.entities.Card;
import sendable.dao.entities.CardLetter;
import sendable.dao.entities.Payment;
import sendable.logic.dtos.AccountDto;
import sendable.logic.dtos.AddressDto;
import sendable.logic.dtos.CardDto;
import sendable.logic.dtos.CardLetterDto;
import sendable.logic.dtos.PaymentDto;

public class SendableMapper {

	public static CardDto MapCard(Card card) {
		if (card == null) {
			return null;
		}
		CardDto temp = new CardDto(card.getId(), card.getName(), card.getDescription(), card.getImageURL(),
				card.getPrice(), card.isAvailable(), card.getDateAdded());
		temp.setCategoryId(card.getCategory().getId());
		return temp;
	}

	public static PaymentDto MapPayment(Payment payment) {
		try {

			return new PaymentDto(payment.getId(), payment.getCardLetter().getId(), payment.getUser().getId(),
					payment.getShippingAddress().GetAddressString(), payment.getBillingAddress().GetAddressString(),
					payment.getDateAdded(), payment.getPaymentType(), payment.getTotalAmount());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static AddressDto MapAddress(Address address) {
		return new AddressDto(address.getId(), address.getLine1(), address.getLine2(), address.getCity(),
				address.getState(), address.getPostalCode());
	}

	public static AccountDto MapAccount(Account account) {
		return new AccountDto(account.getId(), account.getUser().getId(), account.getCredit(), account.getLastTopUpDate());
	}

	public static List<CardLetterDto> MapCardLetter(List<CardLetter> cardLetters) {
		List<CardLetterDto> allLetters = new ArrayList<CardLetterDto>();	
		for (CardLetter c : cardLetters) {
			allLetters.add(new CardLetterDto(c.getId(),c.getUser().getId(), c.getCard().getId(),c.getRecipient(), c.getMessage(), c.getFont(), c.getTotalCost(), c.getDateAdded()));
		}
		return allLetters;
	}
}
