package com.shepherdmoney.interviewproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shepherdmoney.interviewproject.vo.request.AddCreditCardToUserPayload;
import com.shepherdmoney.interviewproject.vo.request.UpdateBalancePayload;
import com.shepherdmoney.interviewproject.vo.response.CreditCardView;
@Service
public interface CreditCardService {
	public CreditCardView createCreditCard(AddCreditCardToUserPayload addCreditCardToUserPayload);
	public List<CreditCardView> getAllCreditCardsByUserId(int userId);
	public Integer getUserIdByCradNo(String cardNumber);
	public void updateBalanceHistory(UpdateBalancePayload[] payload);
}
