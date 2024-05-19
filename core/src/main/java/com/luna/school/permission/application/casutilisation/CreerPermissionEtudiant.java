package com.luna.school.permission.application.casutilisation;

import com.luna.school.etudiant.application.exception.EtudiantException;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.permission.application.commande.CreerPermissionEleveCommande;
import com.luna.school.permission.application.port.PermissionRepositoryPort;
import com.luna.school.permission.domaine.entite.Permission;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public class CreerPermissionEtudiant {
  private final EtudiantRepositoryPort etudiantRepositoryPort;
  private final PermissionRepositoryPort permissionRepositoryPort;

  public CreerPermissionEtudiant(
      EtudiantRepositoryPort etudiantRepositoryPort, PermissionRepositoryPort permissionRepositoryPort) {
    this.etudiantRepositoryPort = etudiantRepositoryPort;
    this.permissionRepositoryPort = permissionRepositoryPort;
  }

  public void creer(CreerPermissionEleveCommande commande) {
    this.etudiantExiste(commande.getEleveId());
    var permissionEtudiant = new Permission();
    permissionEtudiant.setId(UUID.randomUUID());
    permissionEtudiant.setDateDebut(commande.getDateDebut());
    permissionEtudiant.setDateFin(commande.getDateFin());
    permissionEtudiant.setDescription(commande.getDescription());
    permissionEtudiant.setEnseignantId(commande.getEleveId());
    this.permissionRepositoryPort.enregistrerPermissionEnseignent(permissionEtudiant);
  }

  private void etudiantExiste(UUID etudiantId) {
    Etudiant etudiant = this.etudiantRepositoryPort.recupererParId(etudiantId);
    if (etudiant == null) {
      throw new EtudiantException("cet eleve n'existe pas !");
    }
  }
}
