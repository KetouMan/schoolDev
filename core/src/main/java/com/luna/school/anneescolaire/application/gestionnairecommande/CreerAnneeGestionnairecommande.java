package com.luna.school.anneescolaire.application.gestionnairecommande;

import com.luna.school.anneescolaire.application.casutilisation.CreerAnneeScolaire;
import com.luna.school.anneescolaire.application.commande.CreerAnneeScolaireCommande;
import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * @author BOUA YVES 2024-03-18
 */
public class CreerAnneeGestionnairecommande implements
    GestionnaireCommande<CreerAnneeScolaireCommande> {

  private final CreerAnneeScolaire creerAnneeScolaire;

  public CreerAnneeGestionnairecommande(AnneeScolairePort anneeScolairePort) {
    this.creerAnneeScolaire = new CreerAnneeScolaire(anneeScolairePort);
  }

  @Override
  public void execute(CreerAnneeScolaireCommande commande) {
    this.creerAnneeScolaire.creer(commande);
  }
}
