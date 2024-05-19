package com.luna.school.matiere.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
public class ModifierMatierCommande extends CreerMatiereCommande {
  @NotNull(message ="L'identifiant est recquis !")
  private UUID id;
}
