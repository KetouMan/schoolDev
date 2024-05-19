package com.luna.school.entite;

import com.luna.school.enumeration.Civilite;
import com.luna.school.enumeration.TypePiece;
import com.luna.school.tools.Nationnailite;
import jakarta.persistence.Entity;
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
 * @Author BOUA YVES 2024-05-01 6:36 a.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "personnel")
public class PersonnelTable {

  @Id
  private UUID id;
  private Civilite civilite;
  private Nationnailite nationnailite;
  private String nom;
  private String prenoms;
  private String fonction;
  private String residence;
  private String contact;
  private TypePiece piece;
  private String numeroPiece;
  private String matricule;

}
