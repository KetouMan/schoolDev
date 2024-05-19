package com.luna.school.interfaces.facade.usecase.impl;

import com.luna.school.anneescolaire.application.commande.CreerAnneeScolaireCommande;
import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import com.luna.school.anneescolaire.application.gestionnairecommande.CreerAnneeGestionnairecommande;
import com.luna.school.anneescolaire.application.gestionnairecommande.ModifierAnneeScolaireGestionnairecommande;
import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.interfaces.facade.usecase.AnneeScolaireUseCaseFacade;
import com.luna.school.tools.GestionnaireCommande;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class AnneeScolaireUseCaseFacadeImpl implements AnneeScolaireUseCaseFacade {

  private final GestionnaireCommande<CreerAnneeScolaireCommande> gestionnaireCreerAnneeScolaire;
  private final GestionnaireCommande<ModifierAnneeScolaireCammande> gestionnaireModifierAnneeScolaire;

  public AnneeScolaireUseCaseFacadeImpl(AnneeScolairePort anneeScolairePort) {
    gestionnaireCreerAnneeScolaire = new CreerAnneeGestionnairecommande(anneeScolairePort);
    gestionnaireModifierAnneeScolaire = new ModifierAnneeScolaireGestionnairecommande(
        anneeScolairePort);
  }

  @Override
  public void creer(CreerAnneeScolaireCommande commande) {
    this.gestionnaireCreerAnneeScolaire.execute(commande);
  }

  @Override
  public void modifier(ModifierAnneeScolaireCammande commande) {
    this.gestionnaireModifierAnneeScolaire.execute(commande);
  }
}
