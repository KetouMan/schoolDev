package com.luna.school.personnel.application.casutilisation;

import com.luna.school.enseignant.application.commande.ModifierEnseignantCommande;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.personnel.domaine.entite.Personnel;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-23
 */
@Service
public class ModifierPersonnel {

  private final PersonnelRepositoryPort personnelRepositoryPort;

  public ModifierPersonnel(PersonnelRepositoryPort personnelRepositoryPort) {
    this.personnelRepositoryPort = personnelRepositoryPort;
  }

  public void modifier(ModifierEnseignantCommande commande) {
    Personnel personnel = this.personnelRepositoryPort.recupererParId(commande.getId());
    personnel.setNationnailite(commande.getNationnailite());
    personnel.setCivilite(commande.getCivilite());
    personnel.setNom(commande.getNom());
    personnel.setPrenoms(commande.getPrenoms());
    personnel.setMatricule(commande.getMatricule());
    personnel.setPiece(commande.getPiece());
    personnel.setNumeroPiece(commande.getNumeroPiece());
    personnel.setResidence(commande.getResidence());
    personnel.setContact(commande.getContact());
    this.personnelRepositoryPort.enregistrer(personnel);
  }
}
