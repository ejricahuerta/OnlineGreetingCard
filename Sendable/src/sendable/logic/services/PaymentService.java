package sendable.logic.services;

import java.util.ArrayList;
import java.util.List;


import sendable.dao.entities.Payment;

import sendable.dao.repository.UnitOfWork;
import sendable.logic.dtos.PaymentDto;
import sendable.logic.interfaces.PaymentInterface;
import sendable.logic.mapper.SendableMapper;

public class PaymentService implements PaymentInterface {

	private UnitOfWork unit ;
	
	public PaymentService(UnitOfWork work) {
		unit = work;
	}
	
	private List<PaymentDto> AllPayments = new ArrayList<PaymentDto>();


	@Override
	public List<PaymentDto> ListAlllPayments() {
		
		if(AllPayments.isEmpty())
		{
			for (Payment p : unit.GetPaymentRepo().ListAll()) {
				AllPayments.add(SendableMapper.MapPayment(p));
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

		return payments.get(payments.size() - 1);
	}

	@Override
	public PaymentDto GetLatestPayment() {
		return AllPayments.get(AllPayments.size() - 1);
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

}
