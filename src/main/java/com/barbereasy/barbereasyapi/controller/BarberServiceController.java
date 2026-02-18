package com.barbereasy.barbereasyapi.controller;

import com.barbereasy.barbereasyapi.model.BarberService;
import com.barbereasy.barbereasyapi.service.BarberServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BarberServiceController {

  private final BarberServiceService barberService;

  public BarberServiceController(BarberServiceService barberService) {
    this.barberService = barberService;
  }

  @GetMapping("/service")
  public List<BarberService> getAllServices() {
    return barberService.getAllServices();
    /*List<Map<String, Object>> servicios = new ArrayList<>();

    servicios.add(Map.of(
            "id", 1,
            "name", "Corte clásico",
            "description", "Corte de cabello tradicional con tijera y máquina.",
            "price", 8000
    ));

    servicios.add(Map.of(
            "id", 2,
            "name", "Corte + Barba",
            "description", "Corte de cabello tradicional + Afeitado de barba con navaja",
            "price", 11000
    ));

    servicios.add(Map.of(
            "id", 3,
            "name", "Perfilado de barba",
            "description", "Definición y recorte de barba.",
            "price", 3500
    ));

    servicios.add(Map.of(
            "id", 4,
            "name", "Afeitado completo",
            "description", "Afeitado con toalla caliente y navaja.",
            "price", 5000
    ));

    return servicios;*/
  }

  @PostMapping("/service")
  public BarberService saveService(@RequestBody BarberService service) {
    return barberService.saveService(service);
  }

  @PutMapping("/service/{id}")
  public BarberService updateService(@PathVariable("id") UUID serviceId, @RequestBody BarberService service) {
    return barberService.updateService(serviceId, service);
  }

  @DeleteMapping("/service/{id}")
  public void deleteServiceFromCatalog(@PathVariable("id") UUID serviceId) {
    barberService.deleteService(serviceId);
  }

}
