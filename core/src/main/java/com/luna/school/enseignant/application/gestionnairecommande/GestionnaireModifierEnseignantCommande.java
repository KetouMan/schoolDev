package com.luna.school.enseignant.application.gestionnairecommande;

import com.luna.school.enseignant.application.casutilisation.ModifierEnseignant;
import com.luna.school.enseignant.application.commande.ModifierEnseignantCommande;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class GestionnaireModifierEnseignantCommande implements
    GestionnaireCommande<ModifierEnseignantCommande> {

  private final ModifierEnseignant modifierEnseignant;

  public GestionnaireModifierEnseignantCommande(EnseignantRepositoryPort enseignantRepositoryPort) {
    this.modifierEnseignant = new ModifierEnseignant(enseignantRepositoryPort);
  }

  @Override
  public void execute(ModifierEnseignantCommande commande) {
    this.modifierEnseignant.modifier(commande);
  }
}
