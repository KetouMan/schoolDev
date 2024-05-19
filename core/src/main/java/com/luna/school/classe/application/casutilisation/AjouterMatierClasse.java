package com.luna.school.classe.application.casutilisation;

import com.luna.school.classe.application.commande.AjouterMatierClasseCommande;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.matiere.application.port.MatiereRepositoryPort;
import com.luna.school.matiere.domaine.entite.Matiere;
import java.util.List;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-21
 */
public class AjouterMatierClasse {

  private final MatiereRepositoryPort matiereRepositoryPort;
  private final ClasseRepositoryPort classeRepositoryPort;

  public AjouterMatierClasse(MatiereRepositoryPort matiereRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort) {
    this.matiereRepositoryPort = matiereRepositoryPort;
    this.classeRepositoryPort = classeRepositoryPort;
  }

  public void ajouterMatierClasse(AjouterMatierClasseCommande commande) {
    Matiere matiere = this.matiereRepositoryPort.recupererParId(commande.getMatiereId());
    Classe classe = this.classeRepositoryPort.recupererParId(commande.getClasseId());
    this.verifierMatiereInexistante(commande.getMatiereId());
    classe.setMatieres(List.of(matiere));
    this.classeRepositoryPort.enregistrer(classe);
  }

  private void verifierMatiereInexistante(UUID idMatiere) {
    this.matiereRepositoryPort.recupererParId(idMatiere);
  }
}
