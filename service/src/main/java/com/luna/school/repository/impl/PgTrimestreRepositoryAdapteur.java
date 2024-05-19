package com.luna.school.repository.impl;

import com.luna.school.entite.TrimestreTable;
import com.luna.school.mapper.TrimestreMapper;
import com.luna.school.noyaupartage.ObjetNonTrouver;
import com.luna.school.repository.JpaTrimestreRepository;

import com.luna.school.trimestre.application.exception.TrimestreException;
import com.luna.school.trimestre.application.port.TrimestrePort;
import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * @author mamadou.diarra 2023-09-22
 * @author Anderson Ouattara 2023-09-26
 */
@Repository
public class PgTrimestreRepositoryAdapteur implements TrimestrePort {

  private final JpaTrimestreRepository jpaTrimestreRepository;

  private final TrimestreMapper trimestreMapper;

  public PgTrimestreRepositoryAdapteur(
      JpaTrimestreRepository jpaTrimestreRepository) {
    this.jpaTrimestreRepository = jpaTrimestreRepository;
    this.trimestreMapper = TrimestreMapper.INSTANCE;
  }


  @Override
  public List<TrimestreEssentielVM> lister() {
    return this.jpaTrimestreRepository.findAll()
        .stream().map(this.trimestreMapper::trimestreTableVersTrimestreEssentielVM)
        .collect(Collectors.toList());
  }



  @Override
  public void enregistrer(Trimestre trimestre) {
    TrimestreTable trimestreTable = this.trimestreMapper.trimestreVersTrimestreTable(trimestre);
//    trimestreTable.setAnneeScolaire(this.information.entrepriseTable());
    this.jpaTrimestreRepository.save(trimestreTable);
  }

  @Override
  public boolean libellExiste(String libelle) {
//    return this.jpaTrimestreRepository.existsByLibelle(libelle);
    return true;
  }


  @Override
  public TrimestreDetailVM recupererTrimestreDetailVMParId(UUID trimestreId) {
    TrimestreTable trimestreTable = this.recupererTrimestreTable(trimestreId);
    return this.trimestreTableVersTrimestre(trimestreTable);
  }

  @Override
  public Trimestre recupererParId(UUID id) {
    TrimestreTable trimestreTable = this.recupererTrimestreTable(id);
    return this.trimestreMapper.trimestreTableVersTrimestre(trimestreTable);
  }

  @Override
  public void supprimer(UUID trimestreId) {
    try {
      this.jpaTrimestreRepository.deleteById(trimestreId);
    } catch (Exception e) {
      String message = "Impossible de supprimer cette liste de contrôle, elle contient déjà des entités!";
      throw new TrimestreException(message);
    }
  }

  private TrimestreTable recupererTrimestreTable(UUID trimestreId) {
    return this.jpaTrimestreRepository.findById(trimestreId)
        .orElseThrow(() -> new ObjetNonTrouver("Le trimestre est introuvable !"));
  }

  private TrimestreDetailVM trimestreTableVersTrimestre(TrimestreTable trimestreTable) {
    return this.trimestreMapper.trimestreTableVersTrimestreDetailVM(trimestreTable);
  }

}
