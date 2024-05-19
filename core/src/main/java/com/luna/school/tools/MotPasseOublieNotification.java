package com.luna.school.tools;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Attoungbre Ange François 2023-10-13
 */
@Getter
@AllArgsConstructor
public class MotPasseOublieNotification {
  String nom;
  private String emailUtilisateur;
  private String code;
}
