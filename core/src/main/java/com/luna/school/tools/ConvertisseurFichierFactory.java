package com.luna.school.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author N'LAGNI KWAMIVI MAWUSSI 2024-01-11
 */
public interface ConvertisseurFichierFactory {

    ConvertisseurFichier creer(InputStream inputStream) throws IOException;

    ConvertisseurFichier creer(InputStream inputStream, Map<String, TypeColonne> colonnes, int feuille)
            throws IOException;

  /*ConvertisseurFichier creer(Workbook workbook, Map<String, TypeColonne> colonnes, int feuille)
      throws IOException;*/

    //ConvertisseurFichier creer(InputStream inputStream, Colonnes colonnes) throws IOException;

    ConvertisseurFichier creer(InputStream inputStream, Map<String, TypeColonne> colonnes)
            throws IOException;
}
