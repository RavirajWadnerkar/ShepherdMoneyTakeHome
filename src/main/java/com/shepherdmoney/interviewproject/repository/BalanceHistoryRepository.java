package com.shepherdmoney.interviewproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shepherdmoney.interviewproject.model.BalanceHistory;
@Repository("BalanceHistoryRepo")
public interface BalanceHistoryRepository extends JpaRepository<BalanceHistory, Integer> {

}
