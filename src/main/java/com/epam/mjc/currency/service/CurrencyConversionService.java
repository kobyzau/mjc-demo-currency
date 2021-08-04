package com.epam.mjc.currency.service;

import com.epam.mjc.currency.entity.Currency;
import com.epam.mjc.currency.service.impl.NbrbCurrencyConversionService;

public interface CurrencyConversionService {

  static CurrencyConversionService getInstance() {
    return new NbrbCurrencyConversionService();
  }

  double getConversionRatio(Currency original, Currency target);
}
