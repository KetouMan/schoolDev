package com.luna.school.inscription.application.gestionnairecommande;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.MereEtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.PereEtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.TuteurRepositoryPort;
import com.luna.school.inscription.application.casutilisation.ModifierInscription;
import com.luna.school.inscription.application.commande.ModifierInscriptionCommande;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.tools.GestionnaireCommande;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-01 5:25 a.m..
 */
public class GestionnaireModifierInscriptionCommande implements
    GestionnaireCommande<ModifierInscriptionCommande> {

  private final ModifierInscription modifierInscription;

  public GestionnaireModifierInscriptionCommande(
      InscriptionRepositoryPort inscriptionRepositoryPort,
      PereEtudiantRepositoryPort pereEtudiantRepositoryPort,
      MereEtudiantRepositoryPort mereEtudiantRepositoryPort,
      TuteurRepositoryPort tuteurRepositoryPort,
      EtudiantRepositoryPort etudiantRepositoryPort, ClasseRepositoryPort classeRepositoryPort) {
    this.modifierInscription = new ModifierInscription(inscriptionRepositoryPort,
        pereEtudiantRepositoryPort,
        mereEtudiantRepositoryPort, tuteurRepositoryPort, etudiantRepositoryPort,
        classeRepositoryPort);
  }

  @Override
  public void execute(ModifierInscriptionCommande commande) {
    this.modifierInscription.modifier(commande);
  }
}
