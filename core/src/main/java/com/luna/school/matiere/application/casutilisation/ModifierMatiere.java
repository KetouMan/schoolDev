package com.luna.school.matiere.application.casutilisation;

import com.luna.school.matiere.application.commande.ModifierMatierCommande;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;

/**
 * @author BOUA YVES 2024-04-21
 */
public class ModifierMatiere {
  private final MatiereRepositoryPort matiereRepositoryPort;

  public ModifierMatiere(MatiereRepositoryPort matiereRepositoryPort) {
    this.matiereRepositoryPort = matiereRepositoryPort;
  }

  public void modifier(ModifierMatierCommande commande) {
    this.matiereRepositoryPort.recupererParId(commande.getId());
  }
}
