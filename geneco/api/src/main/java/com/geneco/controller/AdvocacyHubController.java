package com.geneco.controller;

import com.geneco.model.AdvocacyResource;
import com.geneco.service.AdvocacyHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advocacy")
public class AdvocacyHubController {
  @Autowired
  private AdvocacyHubService advocacyHubService;

  // Create a new story
  @PostMapping("/stories")
  public AdvocacyResource createStory(@RequestBody AdvocacyResource story) {
    return advocacyHubService.createStory(story);
  }

  // Get all stories with sorting
  @GetMapping("/stories")
  public List<AdvocacyResource> getAllStories(@RequestParam(defaultValue = "mostRecent") String sortBy) {
    return advocacyHubService.getAllStories(sortBy);
  }

  // Get a story by ID
  @GetMapping("/stories/{id}")
  public AdvocacyResource getStory(@PathVariable String id) {
    return advocacyHubService.getStoryById(id);
  }

  // Add support to a story
  @PutMapping("/stories/{id}/support")
  public AdvocacyResource addSupport(@PathVariable String id) {
    return advocacyHubService.addSupport(id);
  }

  // Add a comment to a story
  @PutMapping("/stories/{id}/comment")
  public AdvocacyResource addComment(
      @PathVariable String id,
      @RequestParam String userId,
      @RequestParam String text) {
    return advocacyHubService.addComment(id, userId, text);
  }
}