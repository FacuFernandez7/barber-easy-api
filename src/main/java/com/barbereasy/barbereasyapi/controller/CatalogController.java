package com.barbereasy.barbereasyapi.controller;

import com.barbereasy.barbereasyapi.model.Catalog;
import com.barbereasy.barbereasyapi.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class CatalogController {

  private final CatalogService catalogService;

  public CatalogController(CatalogService catalogService) {
    this.catalogService = catalogService;
  }

  @GetMapping("/catalog")
  public List<Catalog> getAllUsers() {
    return catalogService.getAllCatalogs();
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

  @PostMapping("/catalog")
  public Catalog saveServiceFromCatalog(@RequestBody Catalog catalog) {
    return catalogService.saveCatalog(catalog);
  }

  @PutMapping("/catalog/{id}")
  public Catalog updateCatalog(@PathVariable("id") UUID catalogId, @RequestBody Catalog catalog) {
    return catalogService.updateCatalog(catalogId, catalog);
  }

  @DeleteMapping("/catalog/{id}")
  public void deleteServiceFromCatalog(@PathVariable("id") UUID catalogId) {
    catalogService.deleteService(catalogId);
  }

}
