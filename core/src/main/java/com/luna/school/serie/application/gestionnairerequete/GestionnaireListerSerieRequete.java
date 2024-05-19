package com.luna.school.serie.application.gestionnairerequete;

import com.luna.school.serie.application.casutilisation.ListerSerie;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.serie.application.vm.SerieEssentielVM;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;

/**
 * @author BOUA YVES 2024-04-02
 */
public class GestionnaireListerSerieRequete implements GestionnaireRequete<List<SerieEssentielVM>,Void> {
private final ListerSerie listerSerie;

  public GestionnaireListerSerieRequete(SerieRepositoryPort serieRepositoryPort) {
    this.listerSerie = new ListerSerie(serieRepositoryPort);
  }

  @Override
  public List<SerieEssentielVM> requete(Void var1) {
    return listerSerie.listerSerie();
  }
}
