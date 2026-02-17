package com.barbereasy.barbereasyapi.repository;

import com.barbereasy.barbereasyapi.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CatalogRepository extends JpaRepository<Catalog, UUID> {
}
