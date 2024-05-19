package com.luna.school.anneescolaire.application.casutilisation;

import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class RecupererAnneeScolaireParId {

  private final AnneeScolairePort anneeScolairePort;

  public RecupererAnneeScolaireParId(AnneeScolairePort anneeScolairePort) {
    this.anneeScolairePort = anneeScolairePort;
  }

  public AnneeScolaireDatailsVM recupererAnneeScolaireParId(UUID id){
    AnneeScolaire anneeScolaire = this.anneeScolairePort.recupererParId(id);
    return new AnneeScolaireDatailsVM(anneeScolaire.getId(),anneeScolaire.getLibelle(),anneeScolaire.getDateDebut(),anneeScolaire.getDateFin());
  }
}
