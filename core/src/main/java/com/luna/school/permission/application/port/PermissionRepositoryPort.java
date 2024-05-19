package com.luna.school.permission.application.port;

import com.luna.school.permission.domaine.entite.Permission;

/**
 * @author BOUA YVES 2024-03-27
 */
public interface PermissionRepositoryPort {

  void enregistrerPermissionEnseignent(Permission permissionEnseignant);

  void enregistrerPermissionPersonnel(Permission permissionPersonnel);
}
