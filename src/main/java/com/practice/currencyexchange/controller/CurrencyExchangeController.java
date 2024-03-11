package com.practice.currencyexchange.controller;

import com.practice.currencyexchange.service.CurrencyExchangeService;
import com.practice.currencyexchange.model.CurrencyExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  @Autowired
  private CurrencyExchangeService exchangeService;

  @Autowired
  private Environment environment;

  private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

  @GetMapping("currency-exchange/from/{from}/to/{to}")
//  @Retry(name = "currency-exchange")
//  @CircuitBreaker(name = "default", fallbackMethod = "exchangeFailure")
//  @RateLimiter(name = "currency-exchange")
  public CurrencyExchange exchange(@PathVariable("from")String from, @PathVariable("to")String to) throws Exception {
    CurrencyExchange currencyExchange = exchangeService.exchangeCurrency(from, to);

    String port = environment.getProperty("server.port");
    String host = environment.getProperty("HOSTNAME");
    currencyExchange.setEnvironment(port+ " "+ host + " v11");
    logger.info("exchange called with"+ from + "to" + to);
//    throw new Exception();
    return currencyExchange;
  }

  public CurrencyExchange exchangeFailure(Exception ex){
    CurrencyExchange currencyExchange = new CurrencyExchange();
    currencyExchange.setEnvironment("Error Occurred, Please try again");
    return currencyExchange;
  }
}
