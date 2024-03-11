package com.practice.currencyexchange.repository;

import com.practice.currencyexchange.model.CurrencyExchange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

  CurrencyExchange getCurrencyExchangeByFromEqualsIgnoreCaseAndToEqualsIgnoreCase(String from, String to);
}
