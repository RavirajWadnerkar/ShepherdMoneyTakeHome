package com.shepherdmoney.interviewproject.vo.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UpdateBalancePayload {

    private String creditCardNumber;
    
    private LocalDate balanceDate;

    public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	private double balanceAmount;
}
