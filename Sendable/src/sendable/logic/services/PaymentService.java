package sendable.logic.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sendable.dao.entities.Address;
import sendable.dao.entities.CardLetter;
import sendable.dao.entities.Payment;
import sendable.dao.entities.User;
import sendable.dao.repository.RepositoryInterface;
import sendable.logic.dtos.PaymentDto;
import sendable.logic.interfaces.PaymentInterface;

public class PaymentService implements PaymentInterface {

	private RepositoryInterface<Payment> paymentRepository;
	private RepositoryInterface<User> userRepository;
	private RepositoryInterface<CardLetter> cardLetterRepository;
	private RepositoryInterface<Address> addressRepository;
	

	private List<PaymentDto> AllPayments;

	public PaymentService(RepositoryInterface<Payment> payment, RepositoryInterface<User> user,
			RepositoryInterface<CardLetter> letter,
			RepositoryInterface<Address> address
			) {
		this.paymentRepository = payment;
		this.userRepository = user;
		this.cardLetterRepository = letter;
		this.addressRepository = address;

		for (Payment p : this.paymentRepository.ListAll()) {
			AllPayments.add(this.MapPayment(p));
		}
	}

	@Override
	public List<PaymentDto> ListAlllPayments() {
		return AllPayments;
	}

	@Override
	public List<PaymentDto> ListAlllUserPayments(int userId) {
		List<PaymentDto> paymentret = new ArrayList<PaymentDto>();
		try {
			this.AllPayments.forEach(p -> {
				if (p.getUserId() == userId) {
					paymentret.add(p);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentret;
	}


	@Override
	public PaymentDto GetLatestPaymentByUser(int userId) {
		List<PaymentDto> payments = new ArrayList<PaymentDto>();
		try {
			this.AllPayments.forEach(p -> {
				if (p.getUserId() == userId) {
					payments.add(p);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return payments.get(payments.size()-1);
	}

	@Override
	public PaymentDto GetLatestPayment() {
		return AllPayments.get(AllPayments.size()-1);
	}

	


	@Override
	public boolean MakePayment(int id, int cardLetterId, int userId, String paymentType, double totalAmount,
			int billingId, int shippingId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean MakePaymentByAccount(int id, int cardLetterId, int userId, int accountId, String paymentType,
			double totalAmount, int billingId, int shippingId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private PaymentDto MapPayment(Payment payment) {
		try {
			return new PaymentDto(payment.getId(), payment.getCardLetterId(), payment.getUserId(),
					payment.getShippingAddress().GetAddressString(), payment.getBillingAddress().GetAddressString(),
					payment.getDateAdded(), payment.getPaymentType(), payment.getTotalAmount());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
