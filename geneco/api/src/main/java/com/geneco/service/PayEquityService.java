package com.geneco.service;

import com.geneco.model.PayEquityData;
import com.geneco.repository.PayEquityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayEquityService {
  @Autowired
  private PayEquityRepository payEquityRepository;

  public List<PayEquityData> getPayEquityByIndustry(String industry) {
    return payEquityRepository.findByIndustry(industry);
  }

  public List<PayEquityData> getPayEquityByRegion(String region) {
    return payEquityRepository.findByRegion(region);
  }
}