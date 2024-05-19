package com.luna.school.etudiant.application.gestionnairecommande;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.tools.Nationnailite;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
@Setter
public class CreerParentMereEtudiantCommande {
  private Civilite civilite;
  private Nationnailite nationnailite;
  private String nom;
  private String prenoms;
  private String fonction;
  private String residence;
  private String contact;
  private TypePiece piece;
  private String numeroPiece;
}
