package com.luna.school.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>Classe entité JPA pour le token.</p>
 *
 * @author N'LAGNI KWAMIVI MAWUSSI 2023-10-11
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tokens")
public class TokenTable {
    @Id
    private UUID id;
    private String token;
    private boolean expirer;
    private boolean revoquer;
}
