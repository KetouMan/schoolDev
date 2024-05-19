package com.luna.school.tools;

import java.util.regex.Pattern;

/**
 * @author N'LAGNI KWAMIVI MAWUSSI 2024-01-08
 */
public enum TypeColonne {
    NUMERIQUE {
        @Override
        Pattern pattern() {
            return Pattern.compile("-?((\\d*\\.\\d+|\\d+)([Ee][+-]?\\d+)?)$");
        }
    },
    CARACTERE {
        @Override
        Pattern pattern() {
            return Pattern.compile("^(?!\\s*$).+");
        }
    },
    DATE {
        @Override
        Pattern pattern() {
            return Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        }
    },
    HEURE {
        @Override
        Pattern pattern() {
            return Pattern.compile("^\\d{2}:\\d{2}:\\d{2}$");
        }
    },
    BOOLEAN {
        @Override
        Pattern pattern() {
            return Pattern.compile("^(OUI|NON|VRAI|FAUX|1|0|TRUE|FALSE)$", Pattern.CASE_INSENSITIVE);
        }
    };

    abstract Pattern pattern();

    public static boolean estValeurNumerique(String valeur) {
        return NUMERIQUE.pattern().matcher(valeur).matches();
    }

    public static boolean estValeurDate(String valeur) {
        return DATE.pattern().matcher(valeur).matches();
    }

    public static boolean estValeurBooleene(String valeur) {
        return BOOLEAN.pattern().matcher(valeur).matches();
    }

    public static boolean estValeurNonVide(String valeur) {
        return CARACTERE.pattern().matcher(valeur).matches();
    }
}
