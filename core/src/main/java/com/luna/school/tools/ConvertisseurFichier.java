package com.luna.school.tools;


import java.util.List;

/**
 * @author N'LAGNI KWAMIVI MAWUSSI 2023-12-18
 */
public interface ConvertisseurFichier {

  List<LigneFichier> convertir();

  boolean finConversion();

  default boolean nonFinConversion() {
    return !finConversion();
  }

  boolean contientDonneesCorrompues();

  default boolean neContientPasDeDonneesCorrompues() {
    return !contientDonneesCorrompues();
  }

  List<ColonneInvalidee> listerColonnesInvalidees();

  //boolean colonnesIntrouvables(Colonnes colonnes);
}
