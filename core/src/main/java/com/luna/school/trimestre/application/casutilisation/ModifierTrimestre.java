package com.luna.school.trimestre.application.casutilisation;

import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;
import com.luna.school.trimestre.application.port.TrimestrePort;
import com.luna.school.trimestre.domaine.entite.Trimestre;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ModifierTrimestre {
private final TrimestrePort trimestrePort;
private final AnneeScolairePort anneeScolairePort;

  public ModifierTrimestre(TrimestrePort trimestrePort, AnneeScolairePort anneeScolairePort) {
    this.trimestrePort = trimestrePort;
    this.anneeScolairePort = anneeScolairePort;
  }

  public void modifier(ModifierTrimestreCommande commande) {
    AnneeScolaire anneeScolaire = this.anneeScolairePort.recupererParId(
        commande.getAnneeScolaireId());
    Trimestre trimestre = this.trimestrePort.recupererParId(commande.getId());
    trimestre.setLibelle(commande.getLibelle());
    trimestre.setDateDebut(commande.getDateDebut());
    trimestre.setDateFin(commande.getDateFin());
    trimestre.setAnneeScolaire(anneeScolaire);
    this.trimestrePort.enregistrer(trimestre);
  }
}
