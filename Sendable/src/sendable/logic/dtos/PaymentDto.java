package sendable.logic.dtos;

public class PaymentDto {

	int Id;
	CardDto CardDto;
	UserDto UserDto;
	AddressDto ShippingDto;
	AddressDto BillingDto;
	String DateAdded;
	String PaymentType;
	double TotalAmount;

	public PaymentDto(int id, CardDto cardDto, UserDto userDto, 
			AddressDto shippingDto, AddressDto billingDto, 
			String dateAdded, String paymentType, double totalAmount) {
		super();
		Id = id;
		CardDto = cardDto;
		UserDto = userDto;
		ShippingDto = shippingDto;
		BillingDto = billingDto;
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

	public CardDto getCardDto() {
		return CardDto;
	}

	public void setCardDto(CardDto cardDto) {
		CardDto = cardDto;
	}

	public UserDto getUserDto() {
		return UserDto;
	}

	public void setUserDto(UserDto userDto) {
		UserDto = userDto;
	}

	public AddressDto getShippingDto() {
		return ShippingDto;
	}

	public void setShippingDto(AddressDto shippingDto) {
		ShippingDto = shippingDto;
	}

	public AddressDto getBillingDto() {
		return BillingDto;
	}

	public void setBillingDto(AddressDto billingDto) {
		BillingDto = billingDto;
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
