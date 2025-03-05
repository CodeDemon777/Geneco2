package com.geneco.service;

import com.geneco.model.AdvocacyResource;
import com.geneco.repository.AdvocacyHubRepository;
import com.geneco.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdvocacyHubService {
  @Autowired
  private AdvocacyHubRepository advocacyHubRepository;

  // Create a new story
  public AdvocacyResource createStory(AdvocacyResource story) {
    story.setCreatedAt(new Date());
    story.setSupports(0);
    return advocacyHubRepository.save(story);
  }

  // Get all stories with sorting
  public List<AdvocacyResource> getAllStories(String sortBy) {
    if ("mostRecent".equals(sortBy)) {
      return advocacyHubRepository.findByOrderByCreatedAtDesc();
    } else {
      return advocacyHubRepository.findAll(); // Default sorting
    }
  }

  // Get a story by ID
  public AdvocacyResource getStoryById(String id) {
    return advocacyHubRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Story not found with ID: " + id));
  }

  // Add support to a story
  public AdvocacyResource addSupport(String id) {
    AdvocacyResource story = getStoryById(id);
    story.setSupports(story.getSupports() + 1);
    return advocacyHubRepository.save(story);
  }

  // Add a comment to a story
  public AdvocacyResource addComment(String storyId, String userId, String text) {
    AdvocacyResource story = getStoryById(storyId);
    story.getComments().add(new AdvocacyResource.Comment(userId, text, new Date()));
    return advocacyHubRepository.save(story);
  }
}