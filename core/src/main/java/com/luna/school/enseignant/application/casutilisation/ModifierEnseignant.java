package com.luna.school.enseignant.application.casutilisation;

import com.luna.school.enseignant.application.commande.ModifierEnseignantCommande;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.domaine.entite.Enseignant;

/**
 * @author BOUA YVES 2024-03-23
 */
public class ModifierEnseignant {

  private final EnseignantRepositoryPort enseignantRepositoryPort;

  public ModifierEnseignant(EnseignantRepositoryPort enseignantRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
  }

  public void modifier(ModifierEnseignantCommande commande) {
    Enseignant enseignant = this.enseignantRepositoryPort.recupererParId(commande.getId());
    enseignant.setNationnailite(commande.getNationnailite());
    enseignant.setCivilite(commande.getCivilite());
    enseignant.setNom(commande.getNom());
    enseignant.setPrenoms(commande.getPrenoms());
    enseignant.setMatricule(commande.getMatricule());
    enseignant.setNumeroEnseignant(commande.getNumeroEnseignant());
    enseignant.setPiece(commande.getPiece());
    enseignant.setNumeroPiece(commande.getNumeroPiece());
    enseignant.setResidence(commande.getResidence());
    enseignant.setContact(commande.getContact());
    this.enseignantRepositoryPort.enregistrer(enseignant);
  }
}
