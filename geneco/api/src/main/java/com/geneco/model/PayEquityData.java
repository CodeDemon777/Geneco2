package com.geneco.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pay_equity_data")
public class PayEquityData {
  @Id
  private String id;
  private String industry;
  private String region;
  private Double payGapPercentage;
  private String companyId;
}