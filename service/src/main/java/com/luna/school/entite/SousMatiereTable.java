package com.luna.school.entite;

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
 * @Author BOUA YVES 2024-05-09 12:40 p.m..
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "serie")
public class SousMatiereTable {

  @Id
  private UUID id;
  private String nomSousMatiere;
  private double note;
}
