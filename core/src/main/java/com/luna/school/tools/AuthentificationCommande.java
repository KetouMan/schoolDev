package com.luna.school.tools;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author N'LAGNI KWAMIVI MAWUSSI 2023-10-09
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthentificationCommande {

    @NotEmpty
    private String email;
    @NotEmpty
    private String motDePasse;
}
