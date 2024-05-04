package com.shepherdmoney.interviewproject.repository;

import com.shepherdmoney.interviewproject.model.CreditCard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Crud repository to store credit cards
 */
@Repository("CreditCardRepo")
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

	List<CreditCard> findAllByUserId(int userId);

	@Query(value = "SELECT USER_ID FROM CREDIT_CARD   WHERE CARD_NUMBER = :cardNumber", nativeQuery = true)
	int getUserIdbyCardNo(@Param("cardNumber")String cardNumber);

	CreditCard findByCardNumber(String creditCardNumber);
}
