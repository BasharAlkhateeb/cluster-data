package com.example.clustereddata.service;

import com.example.clustereddata.entity.Deal;
import com.example.clustereddata.repository.DealRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Service
@Slf4j
public class DealService {
    @Autowired
    private DealRepository dealRepository;

    @Transactional
    public void saveDeals(Deal deal) {
        dealRepository.save(deal);
    }

    public void dealValidation(Deal deal) throws Exception {
        if (ObjectUtils.isEmpty(deal.getDealUniqueId()) || ObjectUtils.isEmpty(deal.getDealAmount())
                || ObjectUtils.isEmpty(deal.getDealTimestamp()) || ObjectUtils.isEmpty(deal.getToCurrencyIsoCode())
                || ObjectUtils.isEmpty(deal.getFromCurrencyIsoCode())) {
            log.error("Missing data fields {}", deal);
            throw new Exception("missing data fields");
        }

        if (deal.getDealAmount().compareTo(BigDecimal.ZERO) <= 0) {
            log.error("Invalid amount {}", deal);
            throw new Exception("invalid amount");
        }

        if (!ObjectUtils.isEmpty(dealRepository.findByDealUniqueId(deal.getDealUniqueId()))) {
            log.error("Duplicate unique id {}", deal);
            throw new Exception("Duplicate unique id");
        }
        if (ObjectUtils.isEmpty(deal.getDealTimestamp())) {
            deal.setDealTimestamp(new Timestamp(new Date().getTime()));
        }
    }


}
