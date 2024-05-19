package com.luna.school.anneescolaire.application.casutilisation;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.luna.school.anneescolaire.application.casutilisation.factory.AnneeScolaireFactory;
import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import com.luna.school.anneescolaire.application.gestionnairecommande.ModifierAnneeScolaireGestionnairecommande;
import com.luna.school.anneescolaire.application.port.AnneeScolairePort;
import com.luna.school.anneescolaire.domaine.entite.AnneeScolaire;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author BOUA YVES 2024-03-21
 */
@ExtendWith(MockitoExtension.class)
class ModifierSerieTest {

  @Mock
  AnneeScolairePort anneeScolairePort;
  @Mock
  AnneeScolaireFactory anneeScolaireFactory;

  ModifierAnneeScolaireGestionnairecommande modifierAnneeScolaireGestionnairecommande;

  @BeforeEach
  void setUp() {
    this.modifierAnneeScolaireGestionnairecommande = new ModifierAnneeScolaireGestionnairecommande(
        anneeScolairePort
    );
  }

  @Test
  @DisplayName("Test la modification d'une opportunite")
  void modifier() {
    //Given
    AnneeScolaire anneeScolaire = new AnneeScolaire(UUID.randomUUID(),"2020-2021",LocalDate.of(2020,8,07),LocalDate.of(2021,6,28));
    anneeScolaire.setId(UUID.randomUUID());
    anneeScolaire.setLibelle("2020-2021");
    anneeScolaire.setDateDebut(LocalDate.of(2020,8,07));
    anneeScolaire.setDateFin(LocalDate.of(2021,6,28));
    UUID id = anneeScolaire.getId();
    String libelle = anneeScolaire.getLibelle();
    LocalDate dateDebut = anneeScolaire.getDateDebut();
    LocalDate dateFin = anneeScolaire.getDateFin();
    ModifierAnneeScolaireCammande commande = new ModifierAnneeScolaireCammande();
    commande.setId(id);
    commande.setLibelle(libelle);
    commande.setDateDebut(dateDebut);
    commande.setDateFin(dateFin);

    //When
    when(this.anneeScolairePort.recupererParId(id))
        .thenReturn((anneeScolaire));
    this.modifierAnneeScolaireGestionnairecommande.execute(commande);

    //Then
    verify(anneeScolairePort, times(1)).enregistrer(any(AnneeScolaire.class));
  }
}