package com.barbereasy.barbereasyapi.service;

import com.barbereasy.barbereasyapi.model.BarberService;
import com.barbereasy.barbereasyapi.repository.BarberServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class BarberServiceService {

  private final BarberServiceRepository barberServiceRepository;

  public BarberServiceService(BarberServiceRepository barberServiceRepository) {
    this.barberServiceRepository = barberServiceRepository;
  }

  public List<BarberService> getAllServices() {
    return barberServiceRepository.findAll();
  }

  public BarberService getServiceById(UUID serviceId) {
    return barberServiceRepository.findById(serviceId).orElse(null);
  }

  public BarberService saveService(BarberService service) {
    barberServiceRepository.save(service);
    barberServiceRepository.flush();
    return service;
  }

  @Transactional
  public BarberService updateService(UUID serviceId, BarberService serviceUpdate) {
    BarberService service = barberServiceRepository.findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found"));
    service.setName(serviceUpdate.getName());
    service.setDescription(serviceUpdate.getDescription());
    service.setPrice(serviceUpdate.getPrice());
    service.setTimeOnMinutes(serviceUpdate.getTimeOnMinutes());
    return service;
  }

  public void deleteService(UUID serviceId) {
    barberServiceRepository.deleteById(serviceId);
  }
}
