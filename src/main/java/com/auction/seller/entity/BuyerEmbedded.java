package com.auction.seller.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BuyerEmbedded implements Serializable{
	private static final long serialVersionUTD = 1L;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "product_id")
	private Integer productId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public static long getSerialversionutd() {
		return serialVersionUTD;
	}
	
	

}
