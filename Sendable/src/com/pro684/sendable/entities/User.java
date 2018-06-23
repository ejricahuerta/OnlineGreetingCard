/**
 * 
 */
package com.pro684.sendable.entities;

/**
 * @author EXD
 *
 */
public class User {

	
	String email;
	String hashedPassword;
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String password) {
		this.email = email;
		this.hashedPassword = password;		
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPassword(String password) {
		this.hashedPassword = password;
		
	}
	
	public String getPassword() {
		return this.hashedPassword;
	}

}
