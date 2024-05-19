package com.luna.school.enseignant.application.gestionnairecommande;

import com.luna.school.enseignant.application.casutilisation.CreerEnseignant;
import com.luna.school.enseignant.application.commande.CreerEnseignantCommande;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class GestionnaireCreerEnseignantCommande implements
    GestionnaireCommande<CreerEnseignantCommande> {

  private final CreerEnseignant creerEnseignant;

  public GestionnaireCreerEnseignantCommande(EnseignantRepositoryPort enseignantRepositoryPort) {

    creerEnseignant = new CreerEnseignant(enseignantRepositoryPort);
  }

  @Override
  public void execute(CreerEnseignantCommande commande) {
    this.creerEnseignant.creer(commande);
  }
}
