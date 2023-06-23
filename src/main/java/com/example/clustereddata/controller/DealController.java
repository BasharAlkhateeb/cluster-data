package com.example.clustereddata.controller;

import com.example.clustereddata.entity.Deal;
import com.example.clustereddata.service.DealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deal")
@Slf4j
@Validated
public class DealController {
    @Autowired
    private DealService dealService;

    @PostMapping("/deal-request")
    public ResponseEntity<?> dealsRequest(@RequestBody @Validated Deal deal){
        try{
            log.info("new deal has been received {}: ",deal);
            dealService.dealValidation(deal);
            dealService.saveDeals(deal);
            return new ResponseEntity<>("Saved successfully",HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error("error saving record {}",e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
