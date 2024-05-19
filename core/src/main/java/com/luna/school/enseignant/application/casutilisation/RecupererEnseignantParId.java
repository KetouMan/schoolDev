package com.luna.school.enseignant.application.casutilisation;

import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.application.vm.EnseignantDetailsVM;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class RecupererEnseignantParId {

  private final EnseignantRepositoryPort enseignantRepositoryPort;

  public RecupererEnseignantParId(EnseignantRepositoryPort enseignantRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
  }


  public EnseignantDetailsVM recupererEnseignantParId(UUID id){
    Enseignant enseignant = this.enseignantRepositoryPort.recupererParId(id);
    return new EnseignantDetailsVM(enseignant.getId(),enseignant.getCivilite() ,enseignant.getNationnailite(),enseignant.getNom(),enseignant.getPrenoms(),enseignant.getResidence(),
        enseignant.getContact(), enseignant.getPiece(), enseignant.getNumeroPiece(),
        enseignant.getMatricule(), enseignant.getNumeroEnseignant());
  }
}
