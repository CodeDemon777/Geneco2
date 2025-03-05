package com.geneco.controller;

import com.geneco.model.PayEquityData;
import com.geneco.service.PayEquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pay-equity")
public class PayEquityController {
  @Autowired
  private PayEquityService payEquityService;

  @GetMapping("/industry/{industry}")
  public List<PayEquityData> getPayEquityByIndustry(@PathVariable String industry) {
    return payEquityService.getPayEquityByIndustry(industry);
  }

  @GetMapping("/region/{region}")
  public List<PayEquityData> getPayEquityByRegion(@PathVariable String region) {
    return payEquityService.getPayEquityByRegion(region);
  }
}