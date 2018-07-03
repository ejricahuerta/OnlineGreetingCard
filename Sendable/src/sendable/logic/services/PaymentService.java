package sendable.logic.services;

import java.util.List;

import sendable.dao.entities.CardLetter;
import sendable.dao.entities.Payment;
import sendable.dao.entities.User;
import sendable.dao.repository.RepositoryInterface;
import sendable.logic.dtos.PaymentDto;
import sendable.logic.interfaces.PaymentInterface;

public class PaymentService implements PaymentInterface{

	
	public PaymentService(RepositoryInterface<Payment> payment,
						RepositoryInterface<User> user,
						RepositoryInterface<CardLetter> letter
			) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void MakePayment(int userId, int cardLetterId, double amount, String shipping, String billing,
			String paymentType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MakePaymentByAccount(int userId, int accountId, int cardLetterId, double amount, String shipping,
			String billing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaymentDto> ListAlllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentDto> ListAlllUserPayments(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentDto> ListUserPaymentsByDate(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentDto GetLatestPaymentByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentDto GetLatestPayment() {
		// TODO Auto-generated method stub
		return null;
	}

}
