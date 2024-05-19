package com.luna.school.personnel.application.casutilisation;

import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import java.util.UUID;

/**
 * @author BOUA YVES
 */
public class SupprimerPersonnel {
  private final EnseignantRepositoryPort enseignantRepositoryPort;

  public SupprimerPersonnel(EnseignantRepositoryPort enseignantRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
  }


  public void supprimer(UUID enseignantId) {
    this.enseignantRepositoryPort.supprimer(enseignantId);
  }

}
