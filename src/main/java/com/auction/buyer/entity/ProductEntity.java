package com.auction.buyer.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="product")
public class ProductEntity {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@Column(name = "bid_end_date")
	private Date bidEndDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	private Category category;
	
	@Column(name = "detailed_description")
	private String detailedDescription;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "starting_price")
	private String startingPrice;
	
	@Column(name = "short_description")
	private String shortDescription;
	
	@Column(name = "seller_first_name")
	private String sellerFirstName;
	
	@Column(name = "seller_last_name")
	private String sellerLastName;
	
	@Column(name = "seller_phone")
	private String sellerPhone;
	
	@Column(name = "seller_pin")
	private String sellerPin;
	
	@Column(name = "seller_state")
	private String sellerState;
	
	@Column(name = "seller_city")
	private String sellerCity;
	
	@Column(name = "seller_address")
	private String sellerAddress;
	
	@Column(name = "seller_email")
	private String sellerEmail;

	
	
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}

	public String getSellerFirstName() {
		return sellerFirstName;
	}

	public void setSellerFirstName(String sellerFirstName) {
		this.sellerFirstName = sellerFirstName;
	}

	public String getSellerLastName() {
		return sellerLastName;
	}

	public void setSellerLastName(String sellerLastName) {
		this.sellerLastName = sellerLastName;
	}

	public String getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public String getSellerPin() {
		return sellerPin;
	}

	public void setSellerPin(String sellerPin) {
		this.sellerPin = sellerPin;
	}

	public String getSellerState() {
		return sellerState;
	}

	public void setSellerState(String sellerState) {
		this.sellerState = sellerState;
	}

	public String getSellerCity() {
		return sellerCity;
	}

	public void setSellerCity(String sellerCity) {
		this.sellerCity = sellerCity;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(String startingPrice) {
		this.startingPrice = startingPrice;
	}
	
	
}
