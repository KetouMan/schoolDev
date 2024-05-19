package com.luna.school.entite;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BOUA YVES 2024-03-23
 */
@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class AdresseEntrepriseTable {

    private String email;
    private String pays;
    private String siteWeb;
    private String contact;
    private String adressePostale;
    private String adresseGeographique;
}
