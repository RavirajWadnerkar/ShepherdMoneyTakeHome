package com.shepherdmoney.interviewproject.vo.request;

import com.shepherdmoney.interviewproject.model.User;

import lombok.Data;

@Data
public class AddCreditCardToUserPayload {
	private int id;

	private String issuanceBank;
	private String cardNumber;
	private String cardHolderName;
	private String expiryDate;
	private int cvv;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIssuanceBank() {
		return issuanceBank;
	}
	public void setIssuanceBank(String issuanceBank) {
		this.issuanceBank = issuanceBank;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
