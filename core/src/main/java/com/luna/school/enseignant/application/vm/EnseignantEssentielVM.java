package com.luna.school.enseignant.application.vm;

import com.luna.school.enumeration.Civilite;
import com.luna.school.tools.Nationnailite;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-04-01
 */
@Getter
@Setter
public class EnseignantEssentielVM {

  private Civilite civilite;
  private Nationnailite nationnailite;
  private String nom;
  private String contact;
  private String matricule;

}
