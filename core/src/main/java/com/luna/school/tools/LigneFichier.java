package com.luna.school.tools;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author N'LAGNI KWAMIVI MAWUSSI 2023-12-18
 */
@Getter
@Setter
@EqualsAndHashCode(of = {"numero"})
public class LigneFichier {

  private final int numero;
  private Map<String, Object> colonnes;

  public LigneFichier(int numero) {
    this.numero = numero;
    this.colonnes = new HashMap<>();
  }


  public void ajouterColonne(String libelleColonne, Object value) {
    if (colonnes.containsKey(libelleColonne)) {
      throw new ColonneAvecMemeLibelleException();
    }
    colonnes.put(libelleColonne, value);
  }

  public Object recupereColonne(String libelleColonne) {
    return colonnes.get(libelleColonne);
  }

  public boolean colonneExiste(String libelleColonne) {
    return Objects.nonNull(colonnes.get(libelleColonne));
  }
}

