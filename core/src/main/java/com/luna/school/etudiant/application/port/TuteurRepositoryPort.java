package com.luna.school.etudiant.application.port;

import com.luna.school.etudiant.domaine.entite.TuteurEtudiant;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface TuteurRepositoryPort {

  boolean matriculeExiste(String matricule);

  void enregistrer(TuteurEtudiant tuteurEtudiant);

  TuteurEtudiant recupererParId(UUID id);
}
