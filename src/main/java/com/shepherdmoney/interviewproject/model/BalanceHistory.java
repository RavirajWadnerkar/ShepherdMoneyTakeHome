package com.shepherdmoney.interviewproject.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BalanceHistory {

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private LocalDate date;

    private double balance;
    
    public BalanceHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BalanceHistory(LocalDate date, double balance) {
		super();
		this.date = date;
		this.balance = balance;
	}

	@ManyToOne
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id")
    private CreditCard creditCard;
    
}
