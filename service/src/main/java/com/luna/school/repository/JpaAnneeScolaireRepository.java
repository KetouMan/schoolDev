package com.luna.school.repository;

import com.luna.school.entite.AnneeScolaireTable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author BOUA YVES 2024-03-21
 */
@Repository
public interface JpaAnneeScolaireRepository extends JpaRepository<AnneeScolaireTable, UUID> {
//  boolean existsByLibelle(String libelle);
}
