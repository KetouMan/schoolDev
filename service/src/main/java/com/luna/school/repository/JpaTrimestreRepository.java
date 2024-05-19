package com.luna.school.repository;

import com.luna.school.entite.TrimestreTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author BOUA YVES 2024-03-21
 */
public interface JpaTrimestreRepository extends JpaRepository<TrimestreTable, UUID> {

  boolean existsByLibelle(String libelle);
}
