package com.luna.school.entite;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.Statut;
import com.luna.school.tools.Nationnailite;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 6:23 a.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "etudiant")
public class EtudiantTable {

  @Id
  private UUID id;
  @Enumerated(EnumType.STRING)
  private Civilite civilite;
  private Statut statut;
  private boolean boursier;
  private String matricule;
  private String nom;
  private String prenoms;
  private LocalDate dateNaissance;
  private String lieuNaissance;
  @Enumerated(EnumType.STRING)
  private Nationnailite nationnailite;
  private String residence;
  private String contact;
  private String contactUrgence;
  private String descriptionProbleSante;
  private boolean orphelinDesDeuxParent;
  private boolean orphelinDeMere;
  private boolean orphelinDesDePere;
  private UUID tuteurId;
  private UUID pereId;
  private UUID mereId;
}
