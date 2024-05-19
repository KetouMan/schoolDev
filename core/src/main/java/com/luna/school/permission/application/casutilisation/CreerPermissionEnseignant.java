package com.luna.school.permission.application.casutilisation;

import com.luna.school.enseignant.application.exception.EnseignantException;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.permission.application.commande.CreerPermissionEnseignantCommande;
import com.luna.school.permission.application.port.PermissionRepositoryPort;
import com.luna.school.permission.domaine.entite.Permission;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-27
 */
public class CreerPermissionEnseignant {
  private final EnseignantRepositoryPort enseignantRepositoryPort;
  private final PermissionRepositoryPort permissionRepositoryPort;

  public CreerPermissionEnseignant(EnseignantRepositoryPort enseignantRepositoryPort,
      PermissionRepositoryPort permissionRepositoryPort) {
    this.enseignantRepositoryPort = enseignantRepositoryPort;
    this.permissionRepositoryPort = permissionRepositoryPort;
  }

  public void creer(CreerPermissionEnseignantCommande commande) {
    this.enseignantExiste(commande.getEnseignantId());
    var permissionEnseignant = new Permission();
    permissionEnseignant.setId(UUID.randomUUID());
    permissionEnseignant.setDateDebut(commande.getDateDebut());
    permissionEnseignant.setDateFin(commande.getDateFin());
    permissionEnseignant.setDescription(commande.getDescription());
    permissionEnseignant.setEnseignantId(commande.getEnseignantId());
    this.permissionRepositoryPort.enregistrerPermissionEnseignent(permissionEnseignant);
  }

  private void enseignantExiste(UUID enseignantId) {
    Enseignant enseignant = this.enseignantRepositoryPort.recupererParId(enseignantId);
    if (enseignant == null) {
      throw new EnseignantException("ce enseignant n'existe pas !");
    }
  }
}
