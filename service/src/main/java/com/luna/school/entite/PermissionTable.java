package com.luna.school.entite;

import jakarta.persistence.Entity;
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
 * @Author BOUA YVES 2024-05-01 6:35 a.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "trimestre")
public class PermissionTable {

  @Id
  private UUID id;
  private LocalDate dateDebut;
  private LocalDate dateFin;
  private String description;
  private UUID demandeurId;
}
