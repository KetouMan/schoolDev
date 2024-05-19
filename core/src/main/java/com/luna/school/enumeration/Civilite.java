package com.luna.school.enumeration;

/**
 * <p>Représente la civilité d'une personne physique.</p>
 *
 * @author Anderson Ouattara 2023-09-22
 */
public enum Civilite {

  MONSIEUR {
    @Override
    public String toString() {
      return "Monsieur";
    }
  },

  MADAME {
    @Override
    public String toString() {
      return "Madame";
    }
  }
}
