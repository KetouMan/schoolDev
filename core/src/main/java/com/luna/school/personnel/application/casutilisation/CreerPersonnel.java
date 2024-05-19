package com.luna.school.personnel.application.casutilisation;

import com.luna.school.enseignant.application.exception.EnseignantException;
import com.luna.school.personnel.application.commande.CreerPersonnelCommande;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.personnel.domaine.entite.Personnel;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public class CreerPersonnel {
private final PersonnelRepositoryPort personnelRepositoryPort;

  public CreerPersonnel(PersonnelRepositoryPort personnelRepositoryPort) {
    this.personnelRepositoryPort = personnelRepositoryPort;
  }

  public void creer(CreerPersonnelCommande commande){
    this.existeParMatricule(commande.getMatricule());
    Personnel personnel = this.genererPersonnel(commande);
    this.personnelRepositoryPort.enregistrer(personnel);
  }

  private Personnel genererPersonnel(CreerPersonnelCommande commande) {
    var personnel = new Personnel();
    personnel.setId(UUID.randomUUID());
    personnel.setCivilite(commande.getCivilite());
    personnel.setNationnailite(commande.getNationnailite());
    personnel.setNom(commande.getNom());
    personnel.setPrenoms(commande.getPrenoms());
    personnel.setFonction(commande.getFonction());
    personnel.setMatricule(commande.getMatricule());
    personnel.setPiece(commande.getPiece());
    personnel.setResidence(commande.getResidence());
    personnel.setContact(commande.getContact());
    return personnel;
  }

  private void existeParMatricule(String matricule) {
    boolean existeParLibelle = this.personnelRepositoryPort.matriculeExiste(matricule);
    if (existeParLibelle){
      throw new EnseignantException("un personnel est déjè enregistré avec ce matricaule:"+matricule);
    }
  }
}
