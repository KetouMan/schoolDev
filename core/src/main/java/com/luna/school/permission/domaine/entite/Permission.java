package com.luna.school.permission.domaine.entite;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
  private UUID id;
  private LocalDate dateDebut;
  private LocalDate dateFin;
  private String description;
  private UUID eleveId;
  private UUID enseignantId;
  private UUID personnelId;

}
