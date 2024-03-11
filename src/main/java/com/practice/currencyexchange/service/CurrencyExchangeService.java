package com.practice.currencyexchange.service;

import com.practice.currencyexchange.model.CurrencyExchange;
import com.practice.currencyexchange.repository.CurrencyExchangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

  @Autowired
  CurrencyExchangeRepository repository;

  public CurrencyExchange exchangeCurrency(String from, String to) {
    return repository.getCurrencyExchangeByFromEqualsIgnoreCaseAndToEqualsIgnoreCase(from, to);
  }
}
