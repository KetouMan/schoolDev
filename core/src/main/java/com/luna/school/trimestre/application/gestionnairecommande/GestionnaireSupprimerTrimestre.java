package com.luna.school.trimestre.application.gestionnairecommande;


import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.trimestre.application.casutilisation.SupprimerTrimestre;
import com.luna.school.trimestre.application.port.TrimestrePort;
import java.util.UUID;

/**
 * @author mamadou.diarra 2023-09-22
 */
public class GestionnaireSupprimerTrimestre implements GestionnaireCommande<UUID> {

  private final SupprimerTrimestre supprimerTrimestre;

  public GestionnaireSupprimerTrimestre(
      TrimestrePort trimestrePort
  ) {
    this.supprimerTrimestre = new SupprimerTrimestre(trimestrePort);
  }

  @Override
  public void execute(UUID trimestreId) {
    this.supprimerTrimestre.supprimer(trimestreId);
  }
}
