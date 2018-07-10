package sendable.dao.entities;

import javax.persistence.*;

@Entity
@Table
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;

	String DateAdded;
	String PaymentType;
	double TotalAmount;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	Address BillingAddress;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	Address ShippingAddress;

	@OneToOne(fetch=FetchType.LAZY)
	CardLetter CardLetter;
	@OneToOne(fetch=FetchType.LAZY)
	User User;
	
	public Payment() {

		DateAdded = DateTime.GetCurrentDate();
	}

	public Payment(CardLetter cardLetter, User user, String paymentType, double totalAmount, Address billingAddress,
			Address shippingAddress) {

		PaymentType = paymentType;
		TotalAmount = totalAmount;
		BillingAddress = billingAddress;
		ShippingAddress = shippingAddress;
		this.DateAdded = DateTime.GetCurrentDate();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public CardLetter getCardLetter() {
		return CardLetter;
	}

	public void setCardLetter(CardLetter cardLetter) {
		CardLetter = cardLetter;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
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
