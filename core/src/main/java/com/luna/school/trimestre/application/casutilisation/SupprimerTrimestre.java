package com.luna.school.trimestre.application.casutilisation;

import com.luna.school.trimestre.application.exception.TrimestreException;
import com.luna.school.trimestre.application.port.TrimestrePort;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class SupprimerTrimestre {
  private final TrimestrePort trimestrePort;
  public SupprimerTrimestre(TrimestrePort trimestrePort
	) {
    this.trimestrePort = trimestrePort;
	}

  public void supprimer(UUID annnscolaireID) {
    this.verifierListeControle(annnscolaireID);
    this.trimestrePort.supprimer(annnscolaireID);
  }

  private void verifierListeControle(UUID controleId) {
    Trimestre trimestre = this.trimestrePort.recupererParId(controleId);
    if (trimestre.demarer()) {
        String message = "Impossible d'effectuer la suppression car l'anne n'est pas en cours !";
        throw new TrimestreException(message);
    }
  }
}
