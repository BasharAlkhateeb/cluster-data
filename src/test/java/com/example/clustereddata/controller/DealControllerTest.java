package com.example.clustereddata.controller;

import com.example.clustereddata.entity.Deal;
import com.example.clustereddata.repository.DealRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DealControllerTest {


    @Autowired
    private DealController dealController;

    @Autowired
    private DealRepository dealRepo;

    @Test
    public void testSavingDeal() throws JsonProcessingException {
        String uniqueId = "6";
        String json = "\n" +
                "  {\n" +
                "    \"dealUniqueId\": " + uniqueId + ",\n" +
                "    \"fromCurrencyIsoCode\": \"GBP\",\n" +
                "    \"toCurrencyIsoCode\": \"JPY\",\n" +
                "    \"dealTimestamp\": \"2023-06-23T12:00:00\",\n" +
                "    \"dealAmount\": 2000.00\n" +
                "  }\n" +
                "\n";
        ObjectMapper mapper = new ObjectMapper();
        Deal o = mapper.readValue(json, Deal.class);

        ResponseEntity<?> response = dealController.dealsRequest(o);
        assertEquals("201", response.getStatusCode());
    }
}
