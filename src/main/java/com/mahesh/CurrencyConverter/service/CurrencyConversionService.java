package com.mahesh.CurrencyConverter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import com.mahesh.CurrencyConverter.model.ExchangeRateResponse;

import java.util.Map;

@Service
public class CurrencyConversionService {

    @Value("${api.currency.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Double> getExchangeRates(String baseCurrency) {
        String url = baseUrl + baseCurrency;
        ResponseEntity<ExchangeRateResponse> response = restTemplate.getForEntity(url, ExchangeRateResponse.class);
        return response.getBody().getRates();
    }

    public double convertAmount(double amount, String from, String to) {
        Map<String, Double> rates = getExchangeRates(from);
        double fromRate = rates.get(from);
        double toRate = rates.get(to);
        return amount * (toRate / fromRate);
    }
}

