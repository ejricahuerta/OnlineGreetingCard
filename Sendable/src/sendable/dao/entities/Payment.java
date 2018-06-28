package sendable.dao.entities;

public class Payment  extends BaseEntity{
	
	int CardId;
	int UserId;
	String DateAdded;
	String PaymentType;
	double TotalAmount;
	Address BillingAddress;
	Address ShippingAddress;
	
	public Payment() {
		super(0);
	}

	public Payment(int id, int cardId, int userId, String paymentType, double totalAmount, Address billingAddress,
			Address shippingAddress) {
		super(id);
		CardId = cardId;
		PaymentType = paymentType;
		TotalAmount = totalAmount;
		BillingAddress = billingAddress;
		ShippingAddress = shippingAddress;
	}

	public int getCardId() {
		return CardId;
	}

	public void setCardId(int cardId) {
		CardId = cardId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}

	public String getPaymentType() {
		return PaymentType;
	}

	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public Address getBillingAddress() {
		return BillingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		BillingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return ShippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		ShippingAddress = shippingAddress;
	}
	
	
}
