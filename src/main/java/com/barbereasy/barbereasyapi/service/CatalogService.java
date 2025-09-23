package com.barbereasy.barbereasyapi.service;

import com.barbereasy.barbereasyapi.model.Catalog;
import com.barbereasy.barbereasyapi.repository.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

  private final CatalogRepository catalogRepository;

  public CatalogService(CatalogRepository catalogRepository) {
    this.catalogRepository = catalogRepository;
  }

  public List<Catalog> getAllCatalogs() {
    return catalogRepository.findAll();
  }

  public Catalog getCatalogById(String catalogId) {
    return catalogRepository.findById(catalogId).orElse(null);
  }

  public void saveCatalog(Catalog catalog) {
    catalogRepository.save(catalog);
    catalogRepository.flush();
  }
}
