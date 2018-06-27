package sendable.dao.entities;

public class Payment  extends BaseEntity{
	
	int CardId;
	String DateAdded;
	String PaymentType;
	double TotalAmount;
	Address BillingAddress;
	Address ShippingAddress;
	public Payment() {
		super(0);
	}
	/**
	 * @param id
	 * @param paymentType
	 * @param totalAmount
	 * @param cardId
	 * @param billingAddress
	 * @param shippingAddress
	 */
	public Payment(int id, int cardId, String paymentType, double totalAmount, Address billingAddress,
			Address shippingAddress) {
		super(id);
		CardId = cardId;
		PaymentType = paymentType;
		TotalAmount = totalAmount;
		BillingAddress = billingAddress;
		ShippingAddress = shippingAddress;
	}
}
