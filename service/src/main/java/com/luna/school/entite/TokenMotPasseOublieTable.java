package com.luna.school.entite;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Attoungbre Ange François 2023-10-13
 */
@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class TokenMotPasseOublieTable {
  private String code;
  private LocalDateTime validite;
}
