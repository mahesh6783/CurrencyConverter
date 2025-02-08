package com.mahesh.CurrencyConverter.controller;

import com.mahesh.CurrencyConverter.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyConverterController {

    private final CurrencyConversionService conversionService;

    @Autowired
    public CurrencyConverterController(CurrencyConversionService conversionService) {
        this.conversionService = conversionService;
    }

     @GetMapping("/rates")
    public ResponseEntity<?> getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
        try {
            Map<String, Double> rates = conversionService.getExchangeRates(base);
            return ResponseEntity.ok(rates);
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Map.of("error", "The external API is currently unavailable."));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid currency code provided."));
        }
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convertCurrency(@RequestBody Map<String, Object> request) {
        try {
            String from = (String) request.get("from");
            String to = (String) request.get("to");
            double amount = Double.parseDouble(request.get("amount").toString());

            double convertedAmount = conversionService.convertAmount(amount, from, to);

            return ResponseEntity.ok(Map.of(
                    "from", from,
                    "to", to,
                    "amount", amount,
                    "convertedAmount", convertedAmount
            ));
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Map.of("error", "The external API is currently unavailable."));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid currency code provided."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "An unexpected error occurred."));
        }
    }
}

