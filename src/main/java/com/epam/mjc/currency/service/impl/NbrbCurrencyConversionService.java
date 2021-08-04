package com.epam.mjc.currency.service.impl;

import com.epam.mjc.currency.entity.Currency;
import com.epam.mjc.currency.service.CurrencyConversionService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.SneakyThrows;
import org.json.JSONObject;

public class NbrbCurrencyConversionService implements CurrencyConversionService {
  @Override
  public double getConversionRatio(Currency original, Currency target) {
    double originalRate = getRate(original);
    double targetRate = getRate(target);
    return originalRate / targetRate;
  }

  @SneakyThrows
  private double getRate(Currency currency) {
    if (currency == Currency.BYN) {
      return 1;
    }
    URL url = new URL("https://www.nbrb.by/api/exrates/rates/" + currency.getId());
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuilder response = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    JSONObject json = new JSONObject(response.toString());
    double rate = json.getDouble("Cur_OfficialRate");
    double scale = json.getDouble("Cur_Scale");
    return rate / scale;
  }
}
