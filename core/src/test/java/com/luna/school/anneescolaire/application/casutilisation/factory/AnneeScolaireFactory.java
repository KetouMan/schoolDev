package com.luna.school.anneescolaire.application.casutilisation.factory;

import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class AnneeScolaireFactory {
  private final AnneeScolairePort anneeScolairePort;

  public AnneeScolaireFactory(AnneeScolairePort anneeScolairePort) {
    this.anneeScolairePort = anneeScolairePort;
  }

  public void anneeScolaire() {
    AnneeScolaire anneeScolaire = new AnneeScolaire();
    anneeScolaire.setId(UUID.randomUUID());
    anneeScolaire.setLibelle("2020-2021");
    anneeScolaire.setDateDebut(LocalDate.of(2020,8,07));
    anneeScolaire.setDateFin(LocalDate.of(2021,6,28));
    this.anneeScolairePort.enregistrer(anneeScolaire);
  }

}
