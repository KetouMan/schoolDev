package com.luna.school.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 6:32 a.m..
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "niveau")
public class NiveauTable {

  @Id
  private UUID id;
  private String nom;
  @OneToMany
  private List<ClasseTable> classe;
  private BigDecimal montantScolarite;

}
