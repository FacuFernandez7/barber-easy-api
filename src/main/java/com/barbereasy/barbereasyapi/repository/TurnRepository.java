package com.barbereasy.barbereasyapi.repository;

import com.barbereasy.barbereasyapi.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TurnRepository extends JpaRepository<Turn, UUID> {
}
