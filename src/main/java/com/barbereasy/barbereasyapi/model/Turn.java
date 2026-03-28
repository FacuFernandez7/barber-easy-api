package com.barbereasy.barbereasyapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "turn", schema = "public")
public class Turn {

  @Id
  @GeneratedValue
  @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "appointment_date")
  private LocalDateTime appointmentDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", length = 20)
  private TurnStatus status;

  @Column(name = "customer_name", length = 100)
  private String customerName;

  @ManyToOne
  @JoinColumn(name = "service_id")
  private BarberService barberService;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public Turn() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

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

  public BarberService getBarberService() {
    return barberService;
  }

  public void setBarberService(BarberService barberService) {
    this.barberService = barberService;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }
}
