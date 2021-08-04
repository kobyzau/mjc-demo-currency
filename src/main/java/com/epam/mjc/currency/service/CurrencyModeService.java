package com.epam.mjc.currency.service;

import com.epam.mjc.currency.entity.Currency;
import com.epam.mjc.currency.service.impl.HashMapCurrencyModeService;

public interface CurrencyModeService {

  static CurrencyModeService getInstance() {
    return new HashMapCurrencyModeService();
  }

  Currency getOriginalCurrency(long chatId);

  Currency getTargetCurrency(long chatId);

  void setOriginalCurrency(long chatId, Currency currency);

  void setTargetCurrency(long chatId, Currency currency);
}
