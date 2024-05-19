package com.luna.school.tools;


import com.luna.school.anneescolaire.application.vm.JwtToken;

/**
 * @author N'LAGNI KWAMIVI MAWUSSI 2023-10-11
 */
public interface TokenRepositoryPort {
    void enregistrer(JwtToken token);
}
