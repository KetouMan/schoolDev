package com.luna.school.niveau.application.commande;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-27
 */
@Getter
@Setter
public class CreerNiveauCommande {
  @NotBlank(message ="Le nom du niveau est requis !")
  private String nom;
  @NotBlank(message ="Le montant de la scolarite est requis !")
  private BigDecimal montantScolarite;

}
