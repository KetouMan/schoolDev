package com.luna.school.interfaces.facade.usecase.impl;

import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.interfaces.facade.usecase.TrimestreUseCaseFacade;
import com.luna.school.tools.GestionnaireCommande;
import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;
import com.luna.school.trimestre.application.gestionnairecommande.GestionnaireCreerTrimestreCommande;
import com.luna.school.trimestre.application.gestionnairecommande.GestionnaireModifierTrimestreCommande;
import com.luna.school.trimestre.application.port.TrimestrePort;

/**
 * @author BOUA YVES 2024-03-21
 */
public class TrimestreUseCaseFacadeImpl implements TrimestreUseCaseFacade {

  private final GestionnaireCommande<CreerTrimestreCommande> gestionnaireCreertrimestreCommande;
  private final GestionnaireCommande<ModifierTrimestreCommande> gestionnaireModifierTrimestreCommende;

  public TrimestreUseCaseFacadeImpl(TrimestrePort trimestrePort,
      AnneeScolairePort anneeScolairePort) {
    gestionnaireCreertrimestreCommande = new GestionnaireCreerTrimestreCommande(trimestrePort,
        anneeScolairePort);
    gestionnaireModifierTrimestreCommende = new GestionnaireModifierTrimestreCommande(trimestrePort,
        anneeScolairePort);
  }

  @Override
  public void creer(CreerTrimestreCommande commande) {
    this.gestionnaireCreertrimestreCommande.execute(commande);
  }

  @Override
  public void modifier(ModifierTrimestreCommande commande) {
    this.gestionnaireModifierTrimestreCommende.execute(commande);
  }
}
