package com.auction.buyer.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="buyer")
public class BuyerEntity {
	
	@EmbeddedId
	BuyerEmbedded buyerEmbedded;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pin")
	private String pin;
	
	@Column(name = "phone")
	private String phone;

	
	@Column(name = "bid_amount")
	private Integer bidAmount;
	
	

	public BuyerEmbedded getBuyerEmbedded() {
		return buyerEmbedded;
	}

	public void setBuyerEmbedded(BuyerEmbedded buyerEmbedded) {
		this.buyerEmbedded = buyerEmbedded;
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

	public Integer getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(Integer bidAmount) {
		this.bidAmount = bidAmount;
	}
	
	
}
