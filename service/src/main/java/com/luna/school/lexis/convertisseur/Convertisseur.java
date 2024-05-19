package com.luna.school.lexis.convertisseur;

/**
 * @author mamadou.diarra 2023-10-10
 */
public interface Convertisseur<C, R> {
  R convertir(C commande);
}
