package com.barbereasy.barbereasyapi.controller;

import com.barbereasy.barbereasyapi.model.Turn;
import com.barbereasy.barbereasyapi.model.TurnRequest;
import com.barbereasy.barbereasyapi.service.TurnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TurnController {

  private final TurnService turnService;

  public TurnController(TurnService turnService) {
    this.turnService = turnService;
  }

  @GetMapping("/turn")
  public List<Turn> getAllTurns() {
    return turnService.getAllTurns();
  }

  @PostMapping("/turn")
  public Turn saveTurn(@RequestBody TurnRequest request) {
    return turnService.saveTurn(request);
  }

  @PutMapping("/turn/{id}")
  public Turn updateTurn(@PathVariable("id") UUID turnId, @RequestBody TurnRequest request) {
    return turnService.updateTurn(turnId, request);
  }

  @DeleteMapping("/turn/{id}")
  public void deleteTurn(@PathVariable("id") UUID turnId) {
    turnService.deleteTurn(turnId);
  }
}
