package com.barbereasy.barbereasyapi.service;

import com.barbereasy.barbereasyapi.model.Catalog;
import com.barbereasy.barbereasyapi.repository.CatalogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CatalogService {

  private final CatalogRepository catalogRepository;

  public CatalogService(CatalogRepository catalogRepository) {
    this.catalogRepository = catalogRepository;
  }

  public List<Catalog> getAllCatalogs() {
    return catalogRepository.findAll();
  }

  public Catalog getCatalogById(UUID catalogId) {
    return catalogRepository.findById(catalogId).orElse(null);
  }

  public Catalog saveCatalog(Catalog catalog) {
    catalogRepository.save(catalog);
    catalogRepository.flush();
    return catalog;
  }

  @Transactional
  public Catalog updateCatalog(UUID serviceId, Catalog catalogUpdate) {
    Catalog catalog = catalogRepository.findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Catalog not found"));
    catalog.setName(catalogUpdate.getName());
    catalog.setDescription(catalogUpdate.getDescription());
    catalog.setPrice(catalogUpdate.getPrice());
    catalog.setTimeOnMinutes(catalogUpdate.getTimeOnMinutes());
    return catalog;
  }

  public void deleteService(UUID serviceId) {
    catalogRepository.deleteById(serviceId);
  }
}
