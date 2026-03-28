package com.barbereasy.barbereasyapi.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class TurnRequest {

  private LocalDateTime appointmentDate;
  private TurnStatus status;
  private String customerName;
  private UUID barberService;

  public LocalDateTime getAppointmentDate() {
    return appointmentDate;
  }

  public void setAppointmentDate(LocalDateTime appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  public TurnStatus getStatus() {
    return status;
  }

  public void setStatus(TurnStatus status) {
    this.status = status;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public UUID getBarberService() {
    return barberService;
  }

  public void setBarberService(UUID barberService) {
    this.barberService = barberService;
  }
}
