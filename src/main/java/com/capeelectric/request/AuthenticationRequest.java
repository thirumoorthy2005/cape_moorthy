/**
 * 
 */
package com.capeelectric.request;

/**
 * @author capeelectricsoftware
 *
 */
public class AuthenticationRequest {

	private String email;
	private String password;
	
	public AuthenticationRequest() {
		
	}
	public AuthenticationRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getUserName() {
		return email;
	}
	public void setUserName(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}