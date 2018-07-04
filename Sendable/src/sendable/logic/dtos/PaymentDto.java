package sendable.logic.dtos;

public class PaymentDto {

	int Id;
	int CardLetterId;
	int UserId;
	String Shipping;
	String Billing;
	String DateAdded;
	String PaymentType;
	double TotalAmount;

	/**
	 * @param id
	 * @param cardLetterId
	 * @param UserId
	 * @param Shipping
	 * @param Billing
	 * @param dateAdded
	 * @param paymentType
	 * @param totalAmount
	 */
	public PaymentDto(int id, int cardLetterId, int UserId, String Shipping, String Billing, String dateAdded,
			String paymentType, double totalAmount) {
		super();
		Id = id;
		CardLetterId = cardLetterId;
		this.UserId = UserId;
		this.Shipping = Shipping;
		this.Billing = Billing;
		DateAdded = dateAdded;
		PaymentType = paymentType;
		TotalAmount = totalAmount;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCardLetterId() {
		return CardLetterId;
	}

	public void setCardLetterId(int cardLetterId) {
		CardLetterId = cardLetterId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int UserId) {
		this.UserId = UserId;
	}

	public String getShipping() {
		return Shipping;
	}

	public void setShipping(String Shipping) {
		this.Shipping = Shipping;
	}

	public String getBilling() {
		return Billing;
	}

	public void setBilling(String Billing) {
		this.Billing = Billing;
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

}
