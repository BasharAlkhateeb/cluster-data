package com.example.clustereddata.repository;

import com.example.clustereddata.entity.Deal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DealRepositoryTest {

    @Autowired
    private DealRepository dealRepository;

    @Test
    public void testSavingDeal() {
        String uniqueId = "6";

        Deal deal=dealRepository.findByDealUniqueId(uniqueId);

        assertEquals(deal.getDealUniqueId(),uniqueId);
    }
}
