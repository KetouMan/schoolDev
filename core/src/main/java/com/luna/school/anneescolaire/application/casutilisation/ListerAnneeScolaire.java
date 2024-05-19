package com.luna.school.anneescolaire.application.casutilisation;

import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import java.util.List;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ListerAnneeScolaire {

  private final AnneeScolairePort anneeScolairePort;

  public ListerAnneeScolaire(AnneeScolairePort anneeScolairePort) {
    this.anneeScolairePort = anneeScolairePort;
  }

  public List<AnneeScolaireEssentielVM> listerAnneeScolaire() {
    return this.anneeScolairePort.lister();
  }
}
