package sendable.logic.interfaces;

import java.util.List;

import sendable.logic.dtos.AddressDto;
import sendable.logic.dtos.PaymentDto;

public interface PaymentInterface {

	void MakePayment(int userId, int cardId, double amount, 
			AddressDto shipping, AddressDto billing, String paymentType);
	
	List<PaymentDto> ListAlllUserPayments(int userId);
	
	List<PaymentDto> ListUserPaymentsByDate(String query);
	
	PaymentDto GetLatestPaymentByUser(int userId);
	
	PaymentDto GetLatestPayment();
	
}
