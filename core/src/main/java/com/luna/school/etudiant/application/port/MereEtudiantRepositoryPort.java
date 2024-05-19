package com.luna.school.etudiant.application.port;

import com.luna.school.etudiant.domaine.entite.ParentMereEtudiant;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface MereEtudiantRepositoryPort {

  boolean matriculeExiste(String matricule);

  void enregistrer(ParentMereEtudiant mereEtudiant);

  ParentMereEtudiant recupererParId(UUID id);
}
