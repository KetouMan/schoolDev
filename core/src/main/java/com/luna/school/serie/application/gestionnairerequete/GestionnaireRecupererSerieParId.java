package com.luna.school.serie.application.gestionnairerequete;

import com.luna.school.serie.application.casutilisation.RecupererSerieParId;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.serie.application.vm.SerieDetailsVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireRecupererSerieParId implements GestionnaireRequete<SerieDetailsVM, UUID> {

  private final RecupererSerieParId recupererSerieParId;

  public GestionnaireRecupererSerieParId(SerieRepositoryPort serieRepositoryPort) {
    this.recupererSerieParId = new RecupererSerieParId(serieRepositoryPort);
  }

  @Override
  public SerieDetailsVM requete(UUID id) {
    return this.recupererSerieParId.recupererSerieParId(id);
  }
}
