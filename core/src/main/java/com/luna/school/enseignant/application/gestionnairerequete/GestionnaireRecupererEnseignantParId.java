package com.luna.school.enseignant.application.gestionnairerequete;

import com.luna.school.enseignant.application.casutilisation.RecupererEnseignantParId;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.application.vm.EnseignantDetailsVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireRecupererEnseignantParId implements
    GestionnaireRequete<EnseignantDetailsVM, UUID> {

  private final RecupererEnseignantParId recupererEnseignantParId;

  public GestionnaireRecupererEnseignantParId(EnseignantRepositoryPort enseignantRepositoryPort) {
    recupererEnseignantParId = new RecupererEnseignantParId(enseignantRepositoryPort);
  }


  @Override
  public EnseignantDetailsVM requete(UUID id) {
    return this.recupererEnseignantParId.recupererEnseignantParId(id);
  }
}
