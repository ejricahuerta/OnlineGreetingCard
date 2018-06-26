/**
 * 
 */
package com.pro684.sendable.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author EXD
 *
 */
public class User extends BaseEntity {

	String DateAdded;
	String FullName;
	String Email;
	String HashedPassword;
	Address CurrentAddress;
	Account Account;
	CardLetter CardLetter;

	public User() {
		this.DateAdded = DateTime.GetCurrentDate();
	}
	
	public User(String email, String password) {
		this.DateAdded = DateTime.GetCurrentDate();
		this.Email = email;
		this.HashedPassword = password;
	}
	
	public User(String firstname,String lastname, String password, String email, Address current) {
		this.DateAdded = DateTime.GetCurrentDate();
		this.setFullName(firstname,lastname);
		this.setPassword(password);
		this.setEmail(email);
		this.CurrentAddress = current;
	}

	private void setFullName(String firstname,String lastname) {
		this.FullName = String.format("%s %s", firstname,lastname);
	}
	
	public String getFullName() {
	    return this.FullName;
	}

	private void setEmail(String email) {
		this.Email = email;
	}

	public String getEmail() {
		return this.Email;
	}

	private void setPassword(String password) {
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
}
