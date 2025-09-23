package com.barbereasy.barbereasyapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "catalog", schema = "public")
public class Catalog {

  @Id
  @GeneratedValue
  @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "name", length = 60)
  private String name;

  @Column(name = "description", length = 100)
  private String description;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "time_on_minutes")
  private BigDecimal timeOnMinutes;

  public Catalog() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getTimeOnMinutes() {
    return timeOnMinutes;
  }

  public void setTimeOnMinutes(BigDecimal timeOnMinutes) {
    this.timeOnMinutes = timeOnMinutes;
  }
}
