package com.luna.school.interfaces.facade.query.impl;

import com.luna.school.anneescolaire.application.gestionnairerequete.GestionnaireListerAnnneeScolaireRequete;
import com.luna.school.anneescolaire.application.gestionnairerequete.GestionnaireRecupererAnneeScolaireParId;
import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import com.luna.school.interfaces.facade.query.AnneeScolaireQueryFacade;
import com.luna.school.tools.GestionnaireRequete;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-03-18
 */
@Service
public class AnneeScolaireQueryFacadeImpl implements AnneeScolaireQueryFacade {
 private final GestionnaireRequete<List<AnneeScolaireEssentielVM>,Void> gestionnaireListerAnneeScolaire;
 private final GestionnaireRequete<AnneeScolaireDatailsVM, UUID> gestionnaireRecupereParId;

  public AnneeScolaireQueryFacadeImpl(AnneeScolairePort anneeScolairePort) {
    gestionnaireRecupereParId = new GestionnaireRecupererAnneeScolaireParId(anneeScolairePort);
    gestionnaireListerAnneeScolaire = new GestionnaireListerAnnneeScolaireRequete(anneeScolairePort);
  }

  @Override
  public List<AnneeScolaireEssentielVM> lister() {
    return this.gestionnaireListerAnneeScolaire.requete(null);
  }

  @Override
  public AnneeScolaireDatailsVM recupererParId(UUID id) {
    return this.gestionnaireRecupereParId.requete(id);
  }
}
