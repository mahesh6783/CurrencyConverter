package com.mahesh.CurrencyConverter.controller;

import com.mahesh.CurrencyConverter.service.CurrencyConversionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CurrencyConverterControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CurrencyConversionService conversionService;

    @InjectMocks
    private CurrencyConverterController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetExchangeRates() throws Exception {
        Map<String, Double> mockRates = new HashMap<>();
        mockRates.put("EUR", 0.85);
        mockRates.put("INR", 74.5);

        when(conversionService.getExchangeRates("USD")).thenReturn(mockRates);

        mockMvc.perform(get("/api/rates")
                .param("base", "USD"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.EUR").value(0.85))
                .andExpect(jsonPath("$.INR").value(74.5));
    }

    @Test
    void testConvertCurrency() throws Exception {
        when(conversionService.convertAmount(100, "USD", "EUR")).thenReturn(85.0);

        mockMvc.perform(post("/api/convert")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"from\": \"USD\", \"to\": \"EUR\", \"amount\": 100}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.convertedAmount").value(85.0));
    }
}
