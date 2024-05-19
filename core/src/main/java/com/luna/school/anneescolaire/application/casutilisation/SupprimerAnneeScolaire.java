package com.luna.school.anneescolaire.application.casutilisation;

import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class SupprimerAnneeScolaire {
  private final AnneeScolairePort AnneeScolairePort;
  public SupprimerAnneeScolaire(AnneeScolairePort AnneeScolairePort
	) {
    this.AnneeScolairePort = AnneeScolairePort;
	}

  public void supprimer(UUID annnscolaireID) {
    this.verifierListeControle(annnscolaireID);
    this.AnneeScolairePort.supprimer(annnscolaireID);
  }

  private void verifierListeControle(UUID controleId) {
    AnneeScolaire anneeScolaire = this.AnneeScolairePort.recupererParId(controleId);
    if (!anneeScolaire.anneePrecedente()) {
        String message = "Impossible d'effectuer la suppression car l'anne n'est pas en cours !";
        throw new AnneeScolaireException(message);
    }
  }
}
