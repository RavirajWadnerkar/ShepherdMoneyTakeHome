package com.shepherdmoney.interviewproject.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shepherdmoney.interviewproject.model.BalanceHistory;
import com.shepherdmoney.interviewproject.model.CreditCard;
import com.shepherdmoney.interviewproject.model.User;
import com.shepherdmoney.interviewproject.repository.BalanceHistoryRepository;
import com.shepherdmoney.interviewproject.repository.CreditCardRepository;
import com.shepherdmoney.interviewproject.repository.UserRepository;
import com.shepherdmoney.interviewproject.service.CreditCardService;
import com.shepherdmoney.interviewproject.vo.request.AddCreditCardToUserPayload;
import com.shepherdmoney.interviewproject.vo.request.UpdateBalancePayload;
import com.shepherdmoney.interviewproject.vo.response.CreditCardView;
import com.shepherdmoney.interviewproject.vo.response.UserView;

import jakarta.annotation.PostConstruct;
@Service
public class CreditCardServiceImpl implements CreditCardService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	BalanceHistoryRepository balanceHistoryRepository;

	@Autowired
	CreditCardRepository creditCardRepository;
	private ModelMapper modelMapper;

	@PostConstruct
	public void initializeModelMapper() {
		modelMapper = new ModelMapper();
	}

	@Override
	public CreditCardView createCreditCard(AddCreditCardToUserPayload addCreditCardToUserPayload) {
		
		if(addCreditCardToUserPayload.getId() == 0) {
		User user = userRepository.findById(addCreditCardToUserPayload.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        // Create a new CreditCard object
        CreditCard creditCard = new CreditCard();

        // Set the attributes of the CreditCard object based on the request
        creditCard.setIssuanceBank(addCreditCardToUserPayload.getIssuanceBank());
        creditCard.setCardNumber(addCreditCardToUserPayload.getCardNumber());
        creditCard.setCardHolderName(addCreditCardToUserPayload.getCardHolderName());
        creditCard.setExpiryDate(addCreditCardToUserPayload.getExpiryDate());
        creditCard.setCvv(addCreditCardToUserPayload.getCvv());

        // Set the user for the CreditCard
        creditCard.setUser(user);
     // Save the CreditCard object to the database
        CreditCard savedCreditCard = creditCardRepository.save(creditCard);
        CreditCardView creditCardView = modelMapper.map(savedCreditCard, CreditCardView.class);
        return creditCardView;
		}else {
			
			CreditCard creditCard = creditCardRepository.findById(addCreditCardToUserPayload.getId()).orElseThrow(() -> new RuntimeException("cerdit-card not found"));
			User user = userRepository.findById(addCreditCardToUserPayload.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

	        // Create a new CreditCard object

	        // Set the attributes of the CreditCard object based on the request
	        creditCard.setIssuanceBank(addCreditCardToUserPayload.getIssuanceBank());
	        creditCard.setCardNumber(addCreditCardToUserPayload.getCardNumber());
	        creditCard.setCardHolderName(addCreditCardToUserPayload.getCardHolderName());
	        creditCard.setExpiryDate(addCreditCardToUserPayload.getExpiryDate());
	        creditCard.setCvv(addCreditCardToUserPayload.getCvv());

	        // Set the user for the CreditCard
	        creditCard.setUser(user);
	     // Save the CreditCard object to the database
	        CreditCard savedCreditCard = creditCardRepository.save(creditCard);
	        CreditCardView creditCardView = modelMapper.map(savedCreditCard, CreditCardView.class);
	        return creditCardView;
		}
	}

	@Override
	public List<CreditCardView> getAllCreditCardsByUserId(int userId) {
		List<CreditCardView> creditCardView = new ArrayList<>();
		if(userId > 0) {
			User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
			List<CreditCard> creditCardList = creditCardRepository.findAllByUserId(userId);
			creditCardView = creditCardList.stream()
	                .map(creditCard -> modelMapper.map(creditCard, CreditCardView.class))
	                .collect(Collectors.toList());
			return creditCardView;
		}
		return creditCardView;
	}

	@Override
	public Integer getUserIdByCradNo(String cardNumber) {
		if (cardNumber != null && cardNumber.length() > 0) {
			int id = creditCardRepository.getUserIdbyCardNo(cardNumber);
			return id;
		}
		return null;
	}

	@Override
	public void updateBalanceHistory(UpdateBalancePayload[] payload) {
	    for (UpdateBalancePayload updateBalancePayload : payload) {
	        CreditCard creditCard = creditCardRepository.findByCardNumber(updateBalancePayload.getCreditCardNumber());
	        if (creditCard == null) {
	            throw new IllegalArgumentException("Credit card not found for card number: " + updateBalancePayload.getCreditCardNumber());
	        }

	        List<BalanceHistory> balanceHistory = creditCard.getBalanceHistory();
	        LocalDate today = LocalDate.now();

	        // Create a new BalanceHistory entity
	        BalanceHistory newBalanceHistory = new BalanceHistory();
	        newBalanceHistory.setDate(today);
	        newBalanceHistory.setBalance(updateBalancePayload.getBalanceAmount());
	        newBalanceHistory.setCreditCard(creditCard);

	        // Save the new BalanceHistory entity to the database
	        balanceHistoryRepository.save(newBalanceHistory);

	        // Sort balance history by date in descending order
	        balanceHistory.sort((b1, b2) -> b2.getDate().compareTo(b1.getDate()));

	        // Update balance history with gaps filled and following budgets adjusted
	        balanceHistory = updateBalanceWithGapsFilled(balanceHistory, creditCard);

	        // Set the updated balance history back to the credit card entity
	        creditCard.setBalanceHistory(balanceHistory);

	        // Save the updated credit card entity back to the database
	        creditCardRepository.save(creditCard);
	    }
	}

	private List<BalanceHistory> updateBalanceWithGapsFilled(List<BalanceHistory> balanceHistory, CreditCard creditCard) {
	    List<BalanceHistory> updatedBalanceHistory = new ArrayList<>(balanceHistory);
	    // Logic to fill gaps in balance history and adjust following budgets
	    for (int i = 1; i < updatedBalanceHistory.size(); i++) {
	        BalanceHistory current = updatedBalanceHistory.get(i);
	        BalanceHistory previous = updatedBalanceHistory.get(i - 1);
	        long daysBetween = previous.getDate().toEpochDay() - current.getDate().toEpochDay();
	        if (daysBetween > 1) {
	            // Fill the gap with the previous balance
	            LocalDate currentDate = current.getDate();
	            for (long j = 1; j < daysBetween; j++) {
	                LocalDate date = currentDate.minusDays(j);
	                BalanceHistory gapHistory = new BalanceHistory();
	                gapHistory.setDate(date);
	                gapHistory.setBalance(previous.getBalance());
	                gapHistory.setCreditCard(creditCard);
	                balanceHistoryRepository.save(gapHistory);
	                updatedBalanceHistory.add(gapHistory);
	            }
	        }
	    }
	    return updatedBalanceHistory;
	}
}
