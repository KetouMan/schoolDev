package com.luna.school.mapper;

import com.luna.school.anneescolaire.application.vm.AnneeScolaireDatailsVM;
import com.luna.school.anneescolaire.application.vm.AnneeScolaireEssentielVM;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import com.luna.school.entite.AnneeScolaireTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES 2024-03-21
 */
@Mapper
public abstract class MatiereMapper {

  public static final MatiereMapper INSTANCE = Mappers.getMapper(MatiereMapper.class);

  public abstract AnneeScolaire anneeScolaireTableVersAnneeScolaire(
      AnneeScolaireTable anneeScolaireTable);

  public abstract AnneeScolaireTable anneeScolaireVersAnneeScolaireTable(
      AnneeScolaire appreciation);

  public abstract AnneeScolaireEssentielVM anneeScolaireTAbleVersAnneeScolaireEssentielVM(
      AnneeScolaireTable appreciationTable);

  public abstract AnneeScolaireDatailsVM anneeScolaireTAbleVersAnneeScolaireDatailsVM(
      AnneeScolaireTable appreciationTable);


}
