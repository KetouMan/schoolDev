package com.luna.school.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


/**
 * @author mamadou.diarra 2024-02-05
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
public abstract class AbstractRessourceIT {

  @Container
  static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:latest")
          .withUsername("atlantis_evaluation_user")
          .withPassword("admin")
          .withDatabaseName("atlantis-sirh");
  @Autowired
  protected MockMvc mockMvc;

  @DynamicPropertySource
  static void postGreSqlProperties(DynamicPropertyRegistry registry) {
    container.start();
    registry.add("spring.datasource.url", container::getJdbcUrl);
    registry.add("spring.datasource.username", container::getUsername);
    registry.add("spring.datasource.password", container::getPassword);
    registry.add("spring.jpa.hibernate.ddl-auto", () -> "create");
  }
}
