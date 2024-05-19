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
public class RepresentantLegalTable {

    private String nomRepresentant;
    private String prenomsRepresentant;
    private String emailRepresentant;
    private String contactMobile;
    private String contactRepresentant;
    private String adressePostaleRepresentant;
    private String adresseGeographiqueRepresentant;
}
