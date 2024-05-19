package com.luna.school.etudiant.application.port;

import com.luna.school.etudiant.domaine.entite.ParentPereEtudiant;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface PereEtudiantRepositoryPort {

  boolean matriculeExiste(String matricule);

  void enregistrer(ParentPereEtudiant pereEtudiant);

  ParentPereEtudiant recupererParId(UUID id);
}
