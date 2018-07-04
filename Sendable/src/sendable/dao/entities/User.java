/**
 * 
 */
package sendable.dao.entities;


public class User extends BaseEntity {

	int AccountId;
	int CurrentAddressId;
	Account Account;
	Address CurrentAddress;
	String FullName;
	String Email;
	String Phone;
	String HashedPassword;
	String DateAdded;

	public User() {
		super(0);
		this.DateAdded = DateTime.GetCurrentDate();
	}
	
	public User(String email, String password) {
		super(0);
		this.DateAdded = DateTime.GetCurrentDate();
		this.Email = email;
		this.HashedPassword = password;
	}
	
	public User(String firstname,String lastname, String password, String email, String phone,Address current) {
		super(0);
		this.DateAdded = DateTime.GetCurrentDate();
		this.setFullName(firstname,lastname);
		this.setPassword(password);
		this.setEmail(email);
		this.setPhone(phone);
		this.CurrentAddress = current;
		this.setCurrentAddressId(current.getId());
	}

	public int getAccountId() {
		return AccountId;
	}

	public void setAccountId(int accountId) {
		AccountId = accountId;
	}

	public void setFullName(String firstname,String lastname) {
		this.FullName = String.format("%s %s", firstname,lastname);
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
	
	public void setAddress(String line1, String line2, String city, String state, String postalcode) {
		this.CurrentAddress = new Address(line1,line2,city,state,postalcode); 
	}
	
	public Address getCurrentAddress() {
		return this.CurrentAddress;
	}
	
	public String getCurrentAddressString() {
		return String.format("%s %s %s %s", this.CurrentAddress.getLine1(),
							this.CurrentAddress.getCity(),
							this.CurrentAddress.getState(),
							this.CurrentAddress.getPostalCode());
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}

	public int getCurrentAddressId() {
		return this.CurrentAddressId;
	}

	private void setCurrentAddressId(int currentAddressId) {
		this.CurrentAddressId = currentAddressId;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	
	
}
