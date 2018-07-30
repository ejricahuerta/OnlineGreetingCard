package sendable.logic.interfaces;

import java.util.List;

import sendable.logic.dtos.AddressDto;
import sendable.logic.dtos.PaymentDto;

/**
 * @author ejricahuerta
 * Most of the interfaces are not used but is useful when adding new Functionalities
 *
 */
public interface PaymentInterface {

	boolean MakePayment(int userId, int cardLetterId, String paymentType, double totalAmount, int billingId,
			int shippingId);

	boolean MakePaymentByAccount(int userId, int cardLetterId, String paymentType,
			double totalAmount, AddressDto shipping);

	List<PaymentDto> ListAlllPayments();

	List<PaymentDto> ListAlllUserPayments(int userId);

	PaymentDto GetPaymentByUser(int userId, int paymentId);
}
