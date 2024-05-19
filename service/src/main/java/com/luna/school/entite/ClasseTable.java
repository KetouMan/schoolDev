package com.luna.school.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 6:06 a.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "classe")
public class ClasseTable {

  @Id
  private UUID id;
  private String libelle;
  private UUID professeurPrincipalId;
  @OneToMany
  private List<EtudiantTable> etudiants;
  @OneToMany
  List<MatiereTable> matieres;

}
