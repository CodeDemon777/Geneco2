package com.geneco.repository;

import com.geneco.model.PayEquityData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayEquityRepository extends MongoRepository<PayEquityData, String> {
  List<PayEquityData> findByIndustry(String industry);

  List<PayEquityData> findByRegion(String region);
}