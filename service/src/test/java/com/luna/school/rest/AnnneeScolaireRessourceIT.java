package com.luna.school.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.luna.school.ConfigTest;
import com.luna.school.anneescolaire.application.commande.CreerAnneeScolaireCommande;
import com.luna.school.anneescolaire.application.commande.ModifierAnneeScolaireCammande;
import com.luna.school.entite.AnneeScolaireTable;
import com.luna.school.interfaces.rest.AnnneeScolaireRessource;
import com.luna.school.factory.AnneScolaireFactory;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * <p> {@link  } .</p>
 *
 * @Project school
 * @Author BOUA YVES 2024-05-03 6:59 a.m..
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = ConfigTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AnnneeScolaireRessourceIT {
  private final String API_URL = "/api/luna/scolaire/annee-scolaire";
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  @Autowired(required = false)
  private AnnneeScolaireRessource annneeScolaireRessource;
  @Autowired
  AnneScolaireFactory anneScolaireFactory;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(annneeScolaireRessource)
        .setMessageConverters(mappingJackson2HttpMessageConverter).build();
  }


  @Test
  void creer() throws Exception {
    // Given

    var commande = new CreerAnneeScolaireCommande();
    commande.setLibelle("2024-2025");
    commande.setDateDebut(LocalDate.now());
    commande.setDateFin(LocalDate.of(2023,02,02));
    // When
    var mvcResult = this.mockMvc.perform(post(API_URL)
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isCreated());
  }

  @Test
  void modifier() throws Exception {
    // Given
    AnneeScolaireTable anneeScolaireTable = this.anneScolaireFactory.anneScolaire();
    UUID id = anneeScolaireTable.getId();
    var commande = new ModifierAnneeScolaireCammande();

    commande.setId(id);
    commande.setLibelle("L'année de maintenant");


    // When
    var mvcResult = this.mockMvc.perform(put(API_URL)
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(TestUtils.convertObjectToJsonBytes(commande))
        .contentType(MediaType.APPLICATION_JSON)).andDo(print());

    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void supprimer() throws Exception {
    // Given
    AnneeScolaireTable anneeScolaireTable = this.anneScolaireFactory.anneScolaire();
    // When
    var mvcResult = this.mockMvc.perform(
        delete(API_URL + "/{id}", anneeScolaireTable.getId()));
    // Then
    mvcResult.andExpect(status().isOk());
  }

  @Test
  void recuperer() throws Exception {
    // Given
    AnneeScolaireTable anneeScolaireTable = this.anneScolaireFactory.anneScolaire();
    // When
    var mvcResult = this.mockMvc.perform(get(API_URL + "/{id}", anneeScolaireTable.getId()))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }

  @Test
  void lister() throws Exception {
    // Given
    AnneeScolaireTable anneeScolaireTable = this.anneScolaireFactory.anneScolaire();
    AnneeScolaireTable anneeScolaireTable1= this.anneScolaireFactory.anneScolaire();
    AnneeScolaireTable anneeScolaireTable2 = this.anneScolaireFactory.anneScolaire();

    UUID anneeScolaireTableId = anneeScolaireTable.getId();

    // When
    var mvcResult = this.mockMvc.perform(
            get(API_URL + "/lister"))
        .andDo(print());

    // Then
    mvcResult.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());
  }
}
