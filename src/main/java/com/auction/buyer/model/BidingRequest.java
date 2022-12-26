package com.auction.buyer.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated
public class BidingRequest {

	@NotNull
	@Size(min=5, message="First name should be greater than 5")
	@Size(max=30, message="First name should be less than 30")
	@JsonProperty("firstName")
	private String firstName;
	
	@NotNull
	@Size(min=3, message="Last name should be greater than 3")
	@Size(max=25, message="Last name should be less than 25")
	@JsonProperty("lastName")
	private String lastName;
	
	@NotNull
	@Email
	@Pattern(regexp="(^[a-zA-Z0-9+_.-]+@[a-zA-Z.-]+$)", message = "Invalid Email Address")
	@JsonProperty("emailId")
	private String emailId;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("pin")
	private String pin;
	
	@NotNull
	@Size(min=10, message="Phone number should be of 10 digit")
	@Size(max=10, message="Phone number should be of 10 digit")
	@Pattern(regexp="(^$|[0-9]{10})")
	@JsonProperty("phone")
	private String phone;
	
	@NotNull(message="Product Id cannot be null")
	@JsonProperty("productId")
	private Integer productId;
	
	@NotNull(message="Bid Amount cannot be null")
	@JsonProperty("bidAmount")
	private Integer bidAmount;
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(Integer bidAmount) {
		this.bidAmount = bidAmount;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
