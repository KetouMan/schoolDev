package com.luna.school.entite;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.tools.Nationnailite;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 6:28 a.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "mere_etudiant")
public class ParentMereEtudiantTable {

  @Id
  private UUID id;
  @Enumerated(EnumType.STRING)
  private Civilite civilite;
  @Enumerated(EnumType.STRING)
  private Nationnailite nationnailite;
  private String nom;
  private String prenoms;
  private String fonction;
  private String residence;
  private String contact;
  @Enumerated(EnumType.STRING)
  private TypePiece piece;
  private String numeroPiece;
}
