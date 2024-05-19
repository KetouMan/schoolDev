package com.luna.school.trimestre.application.gestionnairecommande;

import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.trimestre.application.casutilisation.CreerTrimestre;
import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.port.TrimestrePort;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireCreerTrimestreCommande implements
    GestionnaireCommande<CreerTrimestreCommande> {

  private final CreerTrimestre CreeTrimestre;

  public GestionnaireCreerTrimestreCommande(TrimestrePort trimestrePort,
      AnneeScolairePort anneeScolairePort) {
    CreeTrimestre = new CreerTrimestre(trimestrePort, anneeScolairePort);
  }

  @Override
  public void execute(CreerTrimestreCommande commande) {
    this.CreeTrimestre.CreerTrimestre(commande);
  }
}
