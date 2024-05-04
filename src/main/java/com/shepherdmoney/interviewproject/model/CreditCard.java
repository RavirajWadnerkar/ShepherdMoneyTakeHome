package com.shepherdmoney.interviewproject.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String issuanceBank;
    @Column(unique=true)
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private int cvv;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BalanceHistory> getBalanceHistory() {
		return balanceHistory;
	}

	public void setBalanceHistory(List<BalanceHistory> balanceHistory) {
		this.balanceHistory = balanceHistory;
	}
    
    

    // TODO: Credit card's owner. For detailed hint, please see User class
    // Some field here <> owner;

    // TODO: Credit card's balance history. It is a requirement that the dates in the balanceHistory 
    //       list must be in chronological order, with the most recent date appearing first in the list. 
    //       Additionally, the last object in the "list" must have a date value that matches today's date, 
    //       since it represents the current balance of the credit card. For example:
    //       [
    //         {date: '2023-04-10', balance: 800},
    //         {date: '2023-04-11', balance: 1000},
    //         {date: '2023-04-12', balance: 1200},
    //         {date: '2023-04-13', balance: 1100},
    //         {date: '2023-04-16', balance: 900},
    //       ]
    // ADDITIONAL NOTE: For the balance history, you can use any data structure that you think is appropriate.
    //        It can be a list, array, map, pq, anything. However, there are some suggestions:
    //        1. Retrieval of a balance of a single day should be fast
    //        2. Traversal of the entire balance history should be fast
    //        3. Insertion of a new balance should be fast
    //        4. Deletion of a balance should be fast
    //        5. It is possible that there are gaps in between dates (note the 04-13 and 04-16)
    //        6. In the condition that there are gaps, retrieval of "closest" balance date should also be fast. Aka, given 4-15, return 4-16 entry tuple
}
