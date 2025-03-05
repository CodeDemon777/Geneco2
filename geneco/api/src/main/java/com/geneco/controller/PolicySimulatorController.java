package com.geneco.controller;

import com.geneco.model.PolicySimulation;
import com.geneco.service.PolicySimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policy-simulator")
public class PolicySimulatorController {
  @Autowired
  private PolicySimulatorService policySimulatorService;

  // Run a new simulation
  @PostMapping("/simulate")
  public PolicySimulation runSimulation(@RequestBody PolicySimulation input) {
    return policySimulatorService.runSimulation(input);
  }

  // Get simulation results by ID
  @GetMapping("/{id}")
  public PolicySimulation getSimulation(@PathVariable String id) {
    return policySimulatorService.findById(id)
        .orElseThrow(() -> new RuntimeException("Simulation not found"));
  }

  // Compare two simulations
  @PostMapping("/compare")
  public PolicySimulationComparison compare(
      @RequestParam String simulation1Id,
      @RequestParam String simulation2Id) {
    // Implement comparison logic (e.g., return deltas between results)
    return new PolicySimulationComparison();
  }
}

// Helper class for comparison
class PolicySimulationComparison {
  // Define comparison fields (e.g., ROI difference, earnings difference, etc.)
}