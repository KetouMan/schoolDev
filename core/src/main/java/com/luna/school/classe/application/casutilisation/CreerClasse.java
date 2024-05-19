package com.luna.school.classe.application.casutilisation;

import com.luna.school.classe.application.commande.CreerClasseCommande;
import com.luna.school.classe.application.exception.ClasseExecption;
import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.enseignant.application.port.EnseignantRepositoryPort;
import com.luna.school.enseignant.domaine.entite.Enseignant;
import com.luna.school.niveau.application.port.NiveauRepositoryPort;
import com.luna.school.niveau.domaine.entite.Niveau;
import com.luna.school.serie.application.port.SerieRepositoryPort;
import com.luna.school.serie.domaine.entite.Serie;
import java.util.UUID;

/**
 * @author BOUA YVES 2024-04-21
 */
public class CreerClasse {

  private final ClasseRepositoryPort classeRepositoryPort;
  private final NiveauRepositoryPort niveauRepositoryPort;
  private final SerieRepositoryPort serieRepositoryPort;
  private final EnseignantRepositoryPort enseignantRepositoryPort;

  public CreerClasse(ClasseRepositoryPort classeRepositoryPort,
      NiveauRepositoryPort niveauRepositoryPort, SerieRepositoryPort serieRepositoryPort,
      EnseignantRepositoryPort enseignantRepositoryPort) {
    this.classeRepositoryPort = classeRepositoryPort;
    this.niveauRepositoryPort = niveauRepositoryPort;
    this.serieRepositoryPort = serieRepositoryPort;
    this.enseignantRepositoryPort = enseignantRepositoryPort;
  }


  public void creer(CreerClasseCommande commande) {
    this.verifierLibelle(commande.getLibelle());
    this.genererClasse(commande);
    Classe classe = this.genererClasse(commande);
    this.classeRepositoryPort.enregistrer(classe);
  }

  private Classe genererClasse(CreerClasseCommande commande) {
    Niveau niveau = this.niveauRepositoryPort.recupererParId(commande.getNiveauId());
    Serie serie = this.serieRepositoryPort.recupererParId(commande.getSerieId());
    Enseignant enseignant = this.enseignantRepositoryPort
        .recupererParId(commande.getProfesseurPrincipalId());
    var classe = new Classe();
    classe.setId(UUID.randomUUID());
    classe.setLibelle(commande.getLibelle());
    classe.setNiveau(niveau);
    classe.setSerie(serie);
    classe.setProfesseurPrincipal(enseignant);
    return classe;
  }

  private void verifierLibelle(String libelle) {
    boolean existeParLibelle = this.classeRepositoryPort.existsParLibelle(libelle);
    if (existeParLibelle) {
      throw new ClasseExecption("Libelle " + libelle + "existe déjà comme nom de classe");
    }
  }

}
