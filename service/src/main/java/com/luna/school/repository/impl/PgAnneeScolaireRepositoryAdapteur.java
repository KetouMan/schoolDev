package com.luna.school.repository.impl;

import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import com.luna.school.entite.AnneeScolaireTable;
import com.luna.school.mapper.AnneeScolaireMapper;
import com.luna.school.repository.JpaAnneeScolaireRepository;
import com.luna.school.trimestre.application.exception.TrimestreException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * @author BOUA YVES 2024-03-21
 */
@Repository
public class PgAnneeScolaireRepositoryAdapteur implements AnneeScolairePort {

  private final JpaAnneeScolaireRepository jpaAnneeScolaireRepository;
  private final AnneeScolaireMapper anneeScolaireMapper;

  public PgAnneeScolaireRepositoryAdapteur(JpaAnneeScolaireRepository jpaAnneeScolaireRepository) {
    this.jpaAnneeScolaireRepository = jpaAnneeScolaireRepository;
    anneeScolaireMapper = AnneeScolaireMapper.INSTANCE;
  }

  @Override
  public boolean existeParLibelle(String libelle) {
    return true;
//    return this.jpaAnneeScolaireRepository.existsByLibelle(libelle);
  }

  @Override
  public void enregistrer(AnneeScolaire anneeScolaire) {
    AnneeScolaireTable anneeScolaireTable = this.anneeScolaireMapper.anneeScolaireVersAnneeScolaireTable(
        anneeScolaire);
    this.jpaAnneeScolaireRepository.save(anneeScolaireTable);
  }

  @Override
  public Optional<AnneeScolaireDatailsVM> recupererVMParId(UUID id) {
    return this.jpaAnneeScolaireRepository.findById(id)
        .map(this.anneeScolaireMapper::anneeScolaireTAbleVersAnneeScolaireDatailsVM);
  }

  @Override
  public AnneeScolaire recupererParId(UUID id) {
    return null;
  }


  @Override
  public List<AnneeScolaireEssentielVM> lister() {
    List<AnneeScolaireTable> anneeScolaireList = this.jpaAnneeScolaireRepository.findAll();
    return anneeScolaireList.stream()
        .map(this.anneeScolaireMapper::anneeScolaireTAbleVersAnneeScolaireEssentielVM).collect(
            Collectors.toList());
  }

  @Override
  public void supprimer(UUID anneeScolaireId) {
    try {
      this.jpaAnneeScolaireRepository.deleteById(anneeScolaireId);
    } catch (Exception e) {
      String message = "Impossible de supprimer cette liste de contrôle,"
          + " elle contient déjà des entités!";
      throw new TrimestreException(message);
    }
  }
}
