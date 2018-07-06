/**
 * 
 */
package sendable.dao.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;

	String FullName;
	String Email;
	String Phone;
	String HashedPassword;
	String DateAdded;

	@OneToOne
	Account Account;

	@OneToOne
	Address CurrentAddress;

	@OneToMany
	List<Payment> Payments = new ArrayList<Payment>();
	
	public User() {
		this.DateAdded = DateTime.GetCurrentDate();
	}

	public User(String email, String password) {
		this.DateAdded = DateTime.GetCurrentDate();
		this.Email = email;
		this.HashedPassword = password;
	}

	public User(String firstname, String lastname, String password, String email, String phone, Address current) {
		this.DateAdded = DateTime.GetCurrentDate();
		this.setFullName(firstname, lastname);
		this.setPassword(password);
		this.setEmail(email);
		this.setPhone(phone);
		this.CurrentAddress = current;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setFullName(String firstname, String lastname) {
		this.FullName = String.format("%s %s", firstname, lastname);
	}

	public String getFullName() {
		return this.FullName;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setPassword(String password) {
		this.HashedPassword = password;

	}

	public String getPassword() {
		return this.HashedPassword;
	}

	public void setAddress(Address address) {
		this.CurrentAddress = address;
	}

	public Address getCurrentAddress() {
		return this.CurrentAddress;
	}

	public String getCurrentAddressString() {
		return String.format("%s %s %s %s", this.CurrentAddress.getLine1(), this.CurrentAddress.getCity(),
				this.CurrentAddress.getState(), this.CurrentAddress.getPostalCode());
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Account getAccount() {
		return Account;
	}

	public void setAccount(Account account) {
		Account = account;
	}

	public List<Payment> getPayments() {
		return Payments;
	}

	public void setPayments(List<Payment> payments) {
		Payments = payments;
	}

}
