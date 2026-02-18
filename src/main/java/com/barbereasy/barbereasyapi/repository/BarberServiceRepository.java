package com.barbereasy.barbereasyapi.repository;

import com.barbereasy.barbereasyapi.model.BarberService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarberServiceRepository extends JpaRepository<BarberService, UUID> {
}
