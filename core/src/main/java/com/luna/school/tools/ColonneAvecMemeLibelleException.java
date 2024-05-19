package com.luna.school.tools;

/**
 * @author N'LAGNI KWAMIVI MAWUSSI 2024-01-11
 */
public
class ColonneAvecMemeLibelleException extends RuntimeException {

    public ColonneAvecMemeLibelleException() {
        super("Un fichier ne peut pas contenir deux colonnes de même libelle.");
    }
}
