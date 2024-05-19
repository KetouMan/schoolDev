package com.luna.school.mapper;

import com.luna.school.entite.TrimestreTable;
import com.luna.school.trimestre.application.vm.TrimestreDetailVM;
import com.luna.school.trimestre.application.vm.TrimestreEssentielVM;
import com.luna.school.trimestre.domaine.entite.Trimestre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author BOUA YVES
 */
@Mapper
public abstract class TrimestreMapper {

    public static TrimestreMapper INSTANCE = Mappers.getMapper(TrimestreMapper.class);

    public abstract TrimestreTable trimestreVersTrimestreTable(Trimestre trimestre);
    public abstract Trimestre trimestreTableVersTrimestre(TrimestreTable trimestre);

    public abstract TrimestreEssentielVM trimestreTableVersTrimestreEssentielVM(TrimestreTable trimestre);
    @Mapping(target = "anneeScolaireId", source = "anneeScolaire.id")
    public abstract TrimestreDetailVM trimestreTableVersTrimestreDetailVM(TrimestreTable trimestreTable);
}
