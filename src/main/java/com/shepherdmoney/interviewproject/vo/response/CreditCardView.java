package com.shepherdmoney.interviewproject.vo.response;

import java.util.List;

import com.shepherdmoney.interviewproject.model.BalanceHistory;
import com.shepherdmoney.interviewproject.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreditCardView {

	private int id;

	private String issuanceBank;
	private String cardNumber;
	private String cardHolderName;
	private String expiryDate;
	private int cvv;
	private UserViewCreditCard user;
	private List<BalanceHistory> balanceHistory;
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
	public UserViewCreditCard getUser() {
		return user;
	}
	public void setUser(UserViewCreditCard user) {
		this.user = user;
	}
	public List<BalanceHistory> getBalanceHistory() {
		return balanceHistory;
	}
	public void setBalanceHistory(List<BalanceHistory> balanceHistory) {
		this.balanceHistory = balanceHistory;
	}
	
}
