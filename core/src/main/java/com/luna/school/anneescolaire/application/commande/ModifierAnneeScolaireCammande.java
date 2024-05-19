package com.luna.school.anneescolaire.application.commande;

import java.util.UUID;

/**
 * @author BOUA YVES 2024-03-21
 */

public class ModifierAnneeScolaireCammande extends CreerAnneeScolaireCommande{
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
