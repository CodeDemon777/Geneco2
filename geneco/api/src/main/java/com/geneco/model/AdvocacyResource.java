package com.geneco.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "advocacy_resources")
public class AdvocacyResource {
  @Id
  private String id;
  private String title;
  private String category; // Workplace Experiences, Salary Negotiations, etc.
  private String author; // Username or "Anonymous"
  private String content;
  private boolean isAnonymous;
  private int supports;
  private List<Comment> comments;
  private Date createdAt;

  @Data
  public static class Comment {
    private String userId;
    private String text;
    private Date timestamp;
  }
}