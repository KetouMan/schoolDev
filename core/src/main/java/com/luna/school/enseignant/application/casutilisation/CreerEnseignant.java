package com.luna.school.enseignant.application.casutilisation;

import com.luna.school.enseignant.application.commande.CreerEnseignantCommande;
import com.luna.school.enseignant.application.exception.EnseignantException;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-23
 */
public class CreerEnseignant {
private final EnseignantRepositoryPort enseignantRepositoryPort;

  public CreerEnseignant(EnseignantRepositoryPort enseignantRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
  }

  public void creer(CreerEnseignantCommande commande){
    this.existeParMatricule(commande.getMatricule());
    Enseignant enseignant = this.genererEnseignant(commande);
    this.enseignantRepositoryPort.enregistrer(enseignant);
  }

  private Enseignant genererEnseignant(CreerEnseignantCommande commande) {
    var enseignant = new Enseignant();
    enseignant.setId(UUID.randomUUID());
    enseignant.setCivilite(commande.getCivilite());
    enseignant.setNationnailite(commande.getNationnailite());
    enseignant.setNom(commande.getNom());
    enseignant.setPrenoms(commande.getPrenoms());
    enseignant.setMatricule(commande.getMatricule());
    enseignant.setNumeroEnseignant(commande.getNumeroEnseignant());
    enseignant.setPiece(commande.getPiece());
    enseignant.setResidence(commande.getResidence());
    enseignant.setContact(commande.getContact());
    return enseignant;
  }

  private void existeParMatricule(String matricule) {
    boolean existeParLibelle = this.enseignantRepositoryPort.matriculeExiste(matricule);
    if (existeParLibelle){
      throw new EnseignantException("un enseignant est déjè enregistré avec ce matricaule:"+matricule);
    }
  }
}
