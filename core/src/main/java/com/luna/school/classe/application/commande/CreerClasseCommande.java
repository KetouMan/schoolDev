package com.luna.school.classe.application.commande;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Setter
@Getter
public class CreerClasseCommande {

  @NotNull(message = "Le nom de la classe est recquis !")
  private String libelle;
  @NotNull(message = "Le nom de la classe est recquis !")
  private UUID serieId;
  @NotNull(message = "Le niveau est recquis !")
  private UUID niveauId;
  @NotNull(message = "L'identifiant de l'enseignant est recquis !")
  private UUID professeurPrincipalId;

}
