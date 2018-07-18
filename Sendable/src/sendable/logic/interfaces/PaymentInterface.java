package sendable.logic.interfaces;

import java.util.List;
import sendable.logic.dtos.PaymentDto;

public interface PaymentInterface {

	boolean MakePayment(int cardLetterId, String paymentType, double totalAmount, int billingId,
			int shippingId);

	boolean MakePaymentByAccount(int cardLetterId, int accountId, String paymentType,
			double totalAmount, int billingId, int shippingId);

	List<PaymentDto> ListAlllPayments();

	List<PaymentDto> ListAlllUserPayments(int userId);

	PaymentDto GetPaymentByUser(int userId, int paymentId);
}
