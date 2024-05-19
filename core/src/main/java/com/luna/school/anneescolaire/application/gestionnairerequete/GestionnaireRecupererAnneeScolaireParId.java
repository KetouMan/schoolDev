package com.luna.school.anneescolaire.application.gestionnairerequete;

import com.luna.school.anneescolaire.application.casutilisation.RecupererAnneeScolaireParId;
import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireRecupererAnneeScolaireParId implements
    GestionnaireRequete<AnneeScolaireDatailsVM, UUID> {

  private final RecupererAnneeScolaireParId recupererAnneeScolaireParId;

  public GestionnaireRecupererAnneeScolaireParId(
      AnneeScolairePort anneeScolairePort) {
    this.recupererAnneeScolaireParId = new RecupererAnneeScolaireParId(anneeScolairePort);
  }

  @Override
  public AnneeScolaireDatailsVM requete(UUID id) {
    return this.recupererAnneeScolaireParId.recupererAnneeScolaireParId(id);
  }
}
