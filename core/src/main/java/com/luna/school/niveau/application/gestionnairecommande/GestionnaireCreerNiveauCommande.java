package com.luna.school.niveau.application.gestionnairecommande;

import com.luna.school.niveau.application.casutilisation.CreerNiveau;
import com.luna.school.niveau.application.commande.CreerNiveauCommande;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireCreerNiveauCommande implements GestionnaireCommande<CreerNiveauCommande> {
private final CreerNiveau creerNiveau;

  public GestionnaireCreerNiveauCommande(NiveauRepositoryPort niveauRepositoryPort) {
    this.creerNiveau = new CreerNiveau(niveauRepositoryPort);
  }

  @Override
  public void execute(CreerNiveauCommande commande) {
this.creerNiveau.creer(commande);
  }
}
