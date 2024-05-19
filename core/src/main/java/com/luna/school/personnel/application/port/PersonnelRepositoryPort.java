package com.luna.school.personnel.application.port;

import com.luna.school.personnel.domaine.entite.Personnel;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface PersonnelRepositoryPort {

  boolean matriculeExiste(String matricule);

  void enregistrer(Personnel personnel);

  Personnel recupererParId(UUID id);
}
