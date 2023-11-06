package com.betrybe.museumfinder.solution;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testa as classes MuseumController e MuseumService")
public class MuseumTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void expectReturnStatus() throws Exception {
    mockMvc.perform(get("/museums/1")).andExpect(status().isOk());
  }

  @Test
  void expectReturnBody() throws Exception {
    mockMvc.perform(get("/museums/1"))
        .andExpect(jsonPath("$.name").value("Museu Casa Memória dos Ex-Combatentes da Segunda Guerra Mundial"))
        .andExpect(jsonPath("$.description").value("Preservação da memória dos ex-combatentes da Segunda Guerra."))
        .andExpect(jsonPath("$.address").value("SGAN 913, s/n, conjunto F , Asa Norte, 70790-130, Brasília, DF"))
        .andExpect(jsonPath("$.collectionType").value("História"))
        .andExpect(jsonPath("$.subject").value("História"))
        .andExpect(jsonPath("$.url").value(""))
        .andExpect(jsonPath("$.coordinate.latitude").value(-15.75063))
        .andExpect(jsonPath("$.coordinate.longitude").value(-47.9001824));
  }
}
