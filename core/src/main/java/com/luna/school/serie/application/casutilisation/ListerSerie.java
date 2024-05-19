package com.luna.school.serie.application.casutilisation;

import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.serie.application.vm.SerieEssentielVM;
import java.util.List;

/**
 * @author BOUA YVES 2024-03-21
 */
public class ListerSerie {

  private final SerieRepositoryPort serieRepositoryPort;

  public ListerSerie(SerieRepositoryPort serieRepositoryPort) {
    this.serieRepositoryPort = serieRepositoryPort;
  }


  public List<SerieEssentielVM> listerSerie() {
    return this.serieRepositoryPort.lister();
  }
}
