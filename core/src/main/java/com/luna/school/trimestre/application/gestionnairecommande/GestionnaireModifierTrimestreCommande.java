package com.luna.school.trimestre.application.gestionnairecommande;

import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.trimestre.application.casutilisation.ModifierTrimestre;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;
import com.luna.school.trimestre.application.port.TrimestrePort;

/**
 * @author BOUA YVES 2024-03-21
 */
public class GestionnaireModifierTrimestreCommande implements
    GestionnaireCommande<ModifierTrimestreCommande> {

  private final ModifierTrimestre modifierTrimestre;

  public GestionnaireModifierTrimestreCommande(TrimestrePort trimestrePort,
      AnneeScolairePort anneeScolairePort) {
    modifierTrimestre = new ModifierTrimestre(trimestrePort, anneeScolairePort);
  }

  @Override
  public void execute(ModifierTrimestreCommande commande) {
    this.modifierTrimestre.modifier(commande);
  }
}
