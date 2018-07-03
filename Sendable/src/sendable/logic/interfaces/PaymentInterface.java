package sendable.logic.interfaces;

import java.util.List;

import sendable.logic.dtos.AddressDto;
import sendable.logic.dtos.PaymentDto;

public interface PaymentInterface {

	void MakePayment(int userId, int cardLetterId, double amount, 
			String shipping, String billing, String paymentType);

	void MakePaymentByAccount(int userId, int accountId, int cardLetterId, double amount, 
			String shipping, String billing);
	
	
	List<PaymentDto> ListAlllPayments();
	
	List<PaymentDto> ListAlllUserPayments(int userId);
	
	List<PaymentDto> ListUserPaymentsByDate(String query);
	
	PaymentDto GetLatestPaymentByUser(int userId);
	
	PaymentDto GetLatestPayment();
	
}
