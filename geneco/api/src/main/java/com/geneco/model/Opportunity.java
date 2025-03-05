package com.geneco.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "opportunities")
public class Opportunity {
  @Id
  private String id;
  private String title;
  private String type; // "Job", "Grant", "Mentorship", "Educational Resource"
  private String industry; // "Technology", "Finance", "Healthcare", etc.
  private String location; // "Remote", "United States", etc.
  private String company;
  private String description;
  private String applicationLink;
  private Date deadline;
  private String salaryRange; // For jobs
  private String eligibilityCriteria;
  private boolean isActive = true;
}