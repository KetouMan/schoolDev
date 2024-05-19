package com.luna.school.matiere.application.commande;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-10
 */
@Setter
@Getter
public class CreerSousMatiereComande {

  @NotNull(message = "L'indentifiant de la matiere est obligatoire !")
  private UUID matiereId;
  @NotBlank(message = "Le nom de sous matiere est requis !")
  private String nomSousMatiere;
  @NotNull(message = "La note de sous matiere est requis !")
  private double note;
}
