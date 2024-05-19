package com.luna.school.interfaces.facade.usecase;

import com.luna.school.trimestre.application.commande.CreerTrimestreCommande;
import com.luna.school.trimestre.application.commande.ModifierTrimestreCommande;

/**
 * @author BOUA YVES 2024-03-21
 */
public interface TrimestreUseCaseFacade {
  void creer(CreerTrimestreCommande commande);
  void modifier(ModifierTrimestreCommande commande);

}
