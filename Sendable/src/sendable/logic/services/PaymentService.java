package sendable.logic.services;

import java.util.ArrayList;
import java.util.List;

import sendable.dao.entities.Account;
import sendable.dao.entities.Address;
import sendable.dao.entities.CardLetter;
import sendable.dao.entities.Payment;
import sendable.dao.interfaces.UnitOfWorkInterface;
import sendable.dao.repository.UnitOfWork;
import sendable.logic.dtos.PaymentDto;
import sendable.logic.interfaces.PaymentInterface;
import sendable.logic.mapper.SendableMapper;

public class PaymentService implements PaymentInterface {

	private UnitOfWorkInterface unit;

	public PaymentService(UnitOfWorkInterface uow) {
		unit = uow;
	}

	private List<PaymentDto> AllPayments = new ArrayList<PaymentDto>();

	@Override
	public List<PaymentDto> ListAlllPayments() {

		if (AllPayments.isEmpty()) {
			for (Payment p : unit.GetPaymentRepo().ListAll()) {
				AllPayments.add(SendableMapper.mapPaymentDto(p));
			}
		}
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
	public PaymentDto GetPaymentByUser(int userId, int paymentId) {
		if (unit.GetUserRepo().Get(userId) != null) {
			return SendableMapper.mapPaymentDto(this.unit.GetPaymentRepo().Get(paymentId));
		} else {
			return null;
		}
	}

	@Override
	public boolean MakePayment(int userId, int cardLetterId, String paymentType, double totalAmount, int billingId,
			int shippingId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean MakePaymentByAccount(int userId, int cardLetterId, int accountId, String paymentType, double totalAmount,
			int billingId, int shippingId) {
		if(this.unit.GetUserRepo().Get(userId) == null) {
			System.out.println("Unable to find User");
			return false;
		}
		CardLetter letter = this.unit.GetCardLetterRepo().Get(cardLetterId);
		Account account = this.unit.GetAccountRepo().Get(accountId);
		Address shipping = this.unit.GetAddressRepo().Get(shippingId);
		if (account.getCredit() <= totalAmount) {
			return false;
		}
		else if (letter != null) {
			try {
				Payment newpay = new Payment(letter, letter.getUser(), paymentType, totalAmount,
						letter.getUser().getCurrentAddress(), shipping);
				this.unit.GetPaymentRepo().Insert(newpay);
				account.setCredit(account.getCredit()-totalAmount);
				this.unit.GetAccountRepo().Update(account);
				return true;
			} catch (Exception e) {
				System.out.println("Unable to make payment");
				e.printStackTrace();
			}
		}
		return false;
	}
}
