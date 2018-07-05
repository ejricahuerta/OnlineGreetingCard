
package sendable.dao.entities;

import javax.persistence.*;

@Embeddable
@Table
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;

	String Line1;
	String Line2;
	String City;
	String State;
	String PostalCode;

	public Address() {
	}

	public Address(String line1, String line2, String city, String state, String postalcode) {
		this.Line1 = line1;
		this.Line2 = line2;
		this.City = city;
		this.State = state;
		this.PostalCode = postalcode;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public int getId() {
		return this.Id;
	}

	public String getLine1() {
		return this.Line1;
	}

	public String getLine2() {
		return this.Line2;
	}

	public String getCity() {
		return this.City;
	}

	public String getState() {
		return this.State;
	}

	public String getPostalCode() {
		return this.PostalCode;
	}

	public String GetAddressString() {
		if (this.Line2.isEmpty()) {

			return String.format("%s %s %s %s", this.getLine1(), this.getCity(), this.getState(), this.getPostalCode());
		}
		return String.format("%s %s %s %s %s", this.getLine1(), this.getLine2(), this.getCity(), this.getState(),
				this.getPostalCode());
	}

	public void Update(String line1, String line2, String city, String state, String postal) {
		this.Line1 = line1;
		this.Line2 = line2;
		this.City = city;
		this.State = state;
		this.PostalCode = postal;
	}

}
