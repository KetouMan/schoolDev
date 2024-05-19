package com.luna.school.comptabilite.application.port;

import com.luna.school.comptabilite.domaine.entite.Comptabilite;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-21
 */
public interface ComptabiliteRepositoryPort {

  boolean existsParLibelle(String libelle);

  void enregistrer(Comptabilite comptabilite);

  Comptabilite recupererParId(UUID classeId);
}
