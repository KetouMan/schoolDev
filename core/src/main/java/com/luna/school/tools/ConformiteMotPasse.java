package com.luna.school.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Classe de vérification de la conformité des mots de passe.</p>
 *
 * @author mamadou.diarra 2024-03-11
 */
public class ConformiteMotPasse {

    public void verifier(String motPasse) {
        boolean conforme = this.conforme(motPasse);
        if (!conforme) {
            String message = "Le mot de passe doit contenir au moins 8 caractères, au moins une lettre " +
                    "au moins un chiffre et au moins un caractère spécial";
            throw new ConformiteMotPasseException(message);
        }
    }

    public boolean conforme(String motPasse) {
        // Vérifier si le mot de passe comporte au moins 8 caractères, au moins une lettre,
        // au moins un chiffre et au moins un caractère spécial
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(motPasse);
        return matcher.matches();
    }
}
