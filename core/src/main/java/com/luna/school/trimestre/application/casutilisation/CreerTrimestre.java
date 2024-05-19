package com.luna.school.trimestre.application.casutilisation;

import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.exception.TrimestreException;
import com.luna.school.trimestre.application.port.TrimestrePort;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */
public class CreerTrimestre {
  private final TrimestrePort trimestrePort;
  private final AnneeScolairePort anneeScolairePort;

  public CreerTrimestre(TrimestrePort trimestrePort, AnneeScolairePort anneeScolairePort) {
    this.trimestrePort = trimestrePort;
    this.anneeScolairePort = anneeScolairePort;
  }

  public void CreerTrimestre(CreerTrimestreCommande commande) {
    this.verifierLibelleTrimestre(commande.getLibelle());
    AnneeScolaire anneeScolaire = this.anneeScolairePort.recupererParId(
        commande.getAnneeScolaireId());
    var trimestre = new Trimestre();
    trimestre.setId(UUID.randomUUID());
    trimestre.setLibelle(commande.getLibelle());
    trimestre.setDateDebut(commande.getDateDebut());
    trimestre.setDateFin(commande.getDateFin());
    trimestre.setAnneeScolaire(anneeScolaire);
    this.trimestrePort.enregistrer(trimestre);
  }

  private void verifierLibelleTrimestre(String libelle) {
    boolean existeParLibelle = this.trimestrePort.libellExiste(libelle);
    if (existeParLibelle) {
      throw new TrimestreException("Ce libelle existe déjà pour un trimestre !");
    }
  }
}
