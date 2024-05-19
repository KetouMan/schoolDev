package com.luna.school.anneescolaire.application.casutilisation;

import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import com.luna.school.anneescolaire.application.exception.AnneeScolaireException;
import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ModifierAnneeScolaire {

  private final Logger logger = Logger.getLogger(CreerAnneeScolaire.class.getName());
  private final AnneeScolairePort anneeScolairePort;

  public ModifierAnneeScolaire(AnneeScolairePort anneeScolairePort) {
    this.anneeScolairePort = anneeScolairePort;
  }

  public void modifier(ModifierAnneeScolaireCammande commande) {
    AnneeScolaire anneeScolaire = this.anneeScolairePort.recupererParId(commande.getId());
    String libelle = commande.getLibelle();
    this.verifierLibelle(anneeScolaire,libelle);
    anneeScolaire.setLibelle(libelle);
    anneeScolaire.setDateDebut(commande.getDateDebut());
    anneeScolaire.setDateFin(commande.getDateFin());
    this.anneeScolairePort.enregistrer(anneeScolaire);
    logger.info("L'année scolaire modifier avec succès !");
  }

  private void verifierLibelle(AnneeScolaire anneeScolaire,String libelle) {
    boolean existeParLibelle = this.anneeScolairePort.existeParLibelle(libelle);
    if (existeParLibelle && !Objects.equals(anneeScolaire.getLibelle(), libelle)) {
      throw new AnneeScolaireException(
          "Le libelle " + libelle + " existe déjà pour une anné scolaire !");
    }
  }
}
