package com.luna.school.inscription.application.commande;

import com.luna.school.etudiant.application.gestionnairecommande.CreerEtudiantCommende;
import com.luna.school.etudiant.domaine.objetvaleur.DecisionFinAnnee;
import com.luna.school.matiere.domaine.entite.Matiere;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-21
 */
@Getter
@Setter
public class CreerInscriptionCommande {
  private boolean boursier;
  private boolean redouble;
  private Matiere matiereFacultatif;
  private UUID classePrecedanteId;
  private UUID classeActuelleId;
  private boolean releveNote;
  private boolean deposerPhoto;
  private boolean droitInscription;
  private boolean fairePremierVersement;
  private BigDecimal montantVerset;
  private boolean extraitNaisaance;
  private String numeroExtraitNaissance;
  private String etablissementPrecedante;
  private CreerEtudiantCommende creerEtudiantCommende;
  private DecisionFinAnnee decisionFinAnnee;
}
