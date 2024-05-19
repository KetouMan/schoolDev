package com.luna.school.tools;

/**
 * @author N'LAGNI KWAMIVI MAWUSSI 2023-12-18
 */
public record ColonneInvalidee(String libelle, Object valeur, int ligne, Cause cause) {

  public enum Cause {
    TYPE_DONNEE_INCORRECT {
      @Override
      public String toString() {
        return "LE TYPE DE DONNEE INCORRECTE";
      }
    },
    CRITERE_NON_VALIDE {
      @Override
      public String toString() {
        return "NE RESPECTE PAS LE CRITERE DEFINIS SUR LA COLONNE";
      }
    }
  }
}