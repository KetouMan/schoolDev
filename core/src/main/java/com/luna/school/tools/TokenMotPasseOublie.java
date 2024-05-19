package com.luna.school.tools;

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
@AllArgsConstructor
@NoArgsConstructor
public class TokenMotPasseOublie {
  private String code;
  private LocalDateTime validite;
}
