package com.example.clustereddata.service;

import com.example.clustereddata.entity.Deal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DealServiceTest {

    @Autowired
    private DealService dealService;

    @Test
    public void testValidation() throws Exception {
        String uniqueId = "6";
        String json = "\n" +
                "  {\n" +
                "    \"dealUniqueId\": " + uniqueId + ",\n" +
                "    \"fromCurrencyIsoCode\": \"GBP\",\n" +
                "    \"toCurrencyIsoCode\": \"USD\",\n" +
                "    \"dealTimestamp\": \"2023-06-22T12:30:00\",\n" +
                "    \"dealAmount\": 4000.00\n" +
                "  }\n" +
                "\n";
        ObjectMapper mapper = new ObjectMapper();
        Deal o = mapper.readValue(json, Deal.class);

        dealService.dealValidation(o);

    }
}
