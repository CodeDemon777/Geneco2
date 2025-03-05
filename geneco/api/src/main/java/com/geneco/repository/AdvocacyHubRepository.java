package com.geneco.repository;

import com.geneco.model.AdvocacyResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvocacyHubRepository extends MongoRepository<AdvocacyResource, String> {
  List<AdvocacyResource> findByCategory(String category);

  List<AdvocacyResource> findByOrderByCreatedAtDesc();
}