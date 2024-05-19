package com.luna.school.pays.application.casutilisation;

import com.luna.school.pays.application.port.PaysRepositoryPort;
import com.luna.school.pays.application.vm.PaysVM;
import java.util.List;

/**
 * <p>Classe de récuperation des listes des {@link Pays}.</p>
 *
 * @author daniel.kouame 2023-09-21
 */
public class ListePays {
  private final PaysRepositoryPort paysRepositoryPort;

  public ListePays(PaysRepositoryPort paysRepositoryPort) {
    this.paysRepositoryPort = paysRepositoryPort;
  }

  /**
   * <p>Methode de récuperation de la liste des {@link Pays}.</p>
   *
   * @return la Liste des {@link Pays}
   */
  public List<PaysVM> lister() {
    return this.paysRepositoryPort.lister();
  }
}
