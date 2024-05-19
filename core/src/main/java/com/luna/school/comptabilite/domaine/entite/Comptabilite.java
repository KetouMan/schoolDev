package com.luna.school.comptabilite.domaine.entite;

import com.luna.school.etudiant.domaine.entite.Etudiant;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
@Setter
public class Comptabilite {

  private UUID id;
  private String libelle;
  private BigDecimal ScolariteTotale;
  private BigDecimal montantVerset;
  private BigDecimal reste;
  private Etudiant etudiant;
}
