package com.practice.currencyexchange.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CurrencyExchange {
  @Id
  @NonNull
  private Long id;
  @NonNull
  @Column(name = "currency_from")
  private String from;
  @NonNull
  @Column(name = "currency_to")
  private String to;
  @NonNull
  private BigDecimal conversionMultiple;
  private String environment;
}
