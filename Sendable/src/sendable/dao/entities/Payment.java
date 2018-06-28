package sendable.dao.entities;

public class Payment  extends BaseEntity{
	
	int CardId;
	int UserId;
	int ShippingId;
	int BillingId;
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
		this.setBillingId(billingAddress.getId());
		this.setShippingId(shippingAddress.getId());
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

	
	private void setShippingId(int shippingId) {
		ShippingId = shippingId;
	}

	private void setBillingId(int billingId) {
		BillingId = billingId;
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
