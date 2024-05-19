package com.luna.school.enseignant.application.casutilisation;

import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.application.vm.EnseignantEssentielVM;
import java.util.List;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ListerEnseignant {

  private final EnseignantRepositoryPort enseignantRepositoryPort;

  public ListerEnseignant(EnseignantRepositoryPort enseignantRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
  }


  public List<EnseignantEssentielVM> listerEnseignant() {
    return this.enseignantRepositoryPort.lister();
  }
}
