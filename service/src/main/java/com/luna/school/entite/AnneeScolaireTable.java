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
 * @author BOUA YVES 2024-03-18
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "annee_scolaire")
public class AnneeScolaireTable {

  @Id
  private UUID id;
  private String libelle;
  private LocalDate dateDebut;
  private LocalDate dateFin;
}
