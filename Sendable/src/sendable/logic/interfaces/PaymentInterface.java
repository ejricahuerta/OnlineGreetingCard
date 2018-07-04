package sendable.logic.interfaces;

import java.util.List;
import sendable.logic.dtos.PaymentDto;

public interface PaymentInterface {

	boolean MakePayment(int id, int cardLetterId, int userId, String paymentType, double totalAmount, int billingId,
			int shippingId);

	boolean MakePaymentByAccount(int id, int cardLetterId, int userId, int accountId, String paymentType,
			double totalAmount, int billingId, int shippingId);

	List<PaymentDto> ListAlllPayments();

	List<PaymentDto> ListAlllUserPayments(int userId);

	PaymentDto GetLatestPaymentByUser(int userId);

	PaymentDto GetLatestPayment();

}
