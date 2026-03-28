package com.barbereasy.barbereasyapi.service;

import com.barbereasy.barbereasyapi.model.BarberService;
import com.barbereasy.barbereasyapi.model.Turn;
import com.barbereasy.barbereasyapi.model.TurnRequest;
import com.barbereasy.barbereasyapi.repository.BarberServiceRepository;
import com.barbereasy.barbereasyapi.repository.TurnRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TurnService {

  private final TurnRepository turnRepository;
  private final BarberServiceRepository barberServiceRepository;

  public TurnService(TurnRepository turnRepository, BarberServiceRepository barberServiceRepository) {
    this.turnRepository = turnRepository;
    this.barberServiceRepository = barberServiceRepository;
  }

  public List<Turn> getAllTurns() {
    return turnRepository.findAll();
  }

  public Turn getTurnById(UUID turnId) {
    return turnRepository.findById(turnId).orElse(null);
  }

  public Turn saveTurn(TurnRequest request) {
    Turn turn = new Turn();
    turn.setAppointmentDate(request.getAppointmentDate());
    turn.setStatus(request.getStatus());
    turn.setCustomerName(request.getCustomerName());
    if (request.getBarberService() != null) {
      BarberService service = barberServiceRepository.findById(request.getBarberService())
              .orElseThrow(() -> new RuntimeException("Service not found"));
      turn.setBarberService(service);
    }
    return turnRepository.save(turn);
  }

  @Transactional
  public Turn updateTurn(UUID turnId, TurnRequest request) {
    Turn turn = turnRepository.findById(turnId)
            .orElseThrow(() -> new RuntimeException("Turn not found"));
    turn.setAppointmentDate(request.getAppointmentDate());
    turn.setStatus(request.getStatus());
    turn.setCustomerName(request.getCustomerName());
    if (request.getBarberService() != null) {
      BarberService service = barberServiceRepository.findById(request.getBarberService())
              .orElseThrow(() -> new RuntimeException("Service not found"));
      turn.setBarberService(service);
    }
    return turn;
  }

  public void deleteTurn(UUID turnId) {
    turnRepository.deleteById(turnId);
  }
}
