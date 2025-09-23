package com.barbereasy.barbereasyapi.repository;

import com.barbereasy.barbereasyapi.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
}
