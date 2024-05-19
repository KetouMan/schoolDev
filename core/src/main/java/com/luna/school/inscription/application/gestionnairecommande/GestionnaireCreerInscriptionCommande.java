package com.luna.school.inscription.application.gestionnairecommande;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.MereEtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.PereEtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.TuteurRepositoryPort;
import com.luna.school.inscription.application.casutilisation.CreerInscription;
import com.luna.school.inscription.application.commande.CreerInscriptionCommande;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 5:18 a.m..
 */
public class GestionnaireCreerInscriptionCommande implements
    GestionnaireCommande<CreerInscriptionCommande> {

  private final CreerInscription creerInscription;

  public GestionnaireCreerInscriptionCommande(InscriptionRepositoryPort inscriptionRepositoryPort,
      PereEtudiantRepositoryPort pereEtudiantRepositoryPort,
      MereEtudiantRepositoryPort mereEtudiantRepositoryPort,
      TuteurRepositoryPort tuteurRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort, ClasseRepositoryPort classeRepositoryPort) {
    creerInscription = new CreerInscription(inscriptionRepositoryPort, pereEtudiantRepositoryPort,
        mereEtudiantRepositoryPort, tuteurRepositoryPort, etudiantRepositoryPort,
        classeRepositoryPort);
  }

  @Override
  public void execute(CreerInscriptionCommande commande) {
    this.creerInscription.creer(commande);
  }
}
