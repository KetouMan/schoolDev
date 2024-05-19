package com.luna.school.permission.application.casutilisation;

import com.luna.school.enseignant.application.exception.EnseignantException;
import com.luna.school.permission.application.commande.CreerPermissionPersonnelCommande;
import com.luna.school.permission.application.port.PermissionRepositoryPort;
import com.luna.school.permission.domaine.entite.Permission;
import com.luna.school.personnel.application.port.PersonnelRepositoryPort;
import com.luna.school.personnel.domaine.entite.Personnel;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public class CreerPermissionPersonnel {

  private final PersonnelRepositoryPort personnelRepositoryPort;
  private final PermissionRepositoryPort permissionRepositoryPort;

  public CreerPermissionPersonnel(
      PersonnelRepositoryPort personnelRepositoryPort,
      PermissionRepositoryPort permissionRepositoryPort) {
    this.personnelRepositoryPort = personnelRepositoryPort;
    this.permissionRepositoryPort = permissionRepositoryPort;
  }

  public void creer(CreerPermissionPersonnelCommande commande) {
    this.enseignantExiste(commande.getPersonnelId());
    var permissionPersonnel = new Permission();
    permissionPersonnel.setId(UUID.randomUUID());
    permissionPersonnel.setDateDebut(commande.getDateDebut());
    permissionPersonnel.setDateFin(commande.getDateFin());
    permissionPersonnel.setDescription(commande.getDescription());
    permissionPersonnel.setEnseignantId(commande.getPersonnelId());
    this.permissionRepositoryPort.enregistrerPermissionPersonnel(permissionPersonnel);
  }

  private void enseignantExiste(UUID enseignantId) {
    Personnel personnel = this.personnelRepositoryPort.recupererParId(enseignantId);
    if (personnel == null) {
      throw new EnseignantException("ce personnel n'existe pas !");
    }
  }
}
