package com.luna.school.enseignant.application.gestionnairerequete;

import com.luna.school.enseignant.application.casutilisation.ListerEnseignant;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.application.vm.EnseignantEssentielVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireListerEnseignantRequete implements
    GestionnaireRequete<List<EnseignantEssentielVM>, Void> {

  private final ListerEnseignant listerEnseignant;

  public GestionnaireListerEnseignantRequete(EnseignantRepositoryPort enseignantRepositoryPort) {
    this.listerEnseignant = new ListerEnseignant(enseignantRepositoryPort);
  }


  @Override
  public List<EnseignantEssentielVM> requete(Void unused) {
    return this.listerEnseignant.listerEnseignant();
  }
}
