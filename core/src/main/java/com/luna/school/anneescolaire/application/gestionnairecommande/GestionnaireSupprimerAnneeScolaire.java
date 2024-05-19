package com.luna.school.anneescolaire.application.gestionnairecommande;


import com.luna.school.anneescolaire.application.casutilisation.SupprimerAnneeScolaire;
import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.tools.GestionnaireCommande;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class GestionnaireSupprimerAnneeScolaire implements GestionnaireCommande<UUID> {

  private final SupprimerAnneeScolaire supprimerAnneeScolaire;

  public GestionnaireSupprimerAnneeScolaire(
      AnneeScolairePort anneeScolairePort
  ) {
    this.supprimerAnneeScolaire = new SupprimerAnneeScolaire(anneeScolairePort);
  }

  @Override
  public void execute(UUID anneeScolaireId) {
    this.supprimerAnneeScolaire.supprimer(anneeScolaireId);
  }
}
