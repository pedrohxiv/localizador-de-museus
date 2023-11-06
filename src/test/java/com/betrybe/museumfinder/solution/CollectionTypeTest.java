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
@DisplayName("Testa as classes CollectionTypeController e CollectionTypeService")
public class CollectionTypeTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void expectReturnStatus() throws Exception {
    mockMvc.perform(get("/collections/count/hist,imag")).andExpect(status().isOk());
  }

  @Test
  void expectReturnBody() throws Exception {
    mockMvc.perform(get("/collections/count/hist,imag"))
        .andExpect(jsonPath("$.collectionTypes[0]").value("hist"))
        .andExpect(jsonPath("$.collectionTypes[1]").value("imag"))
        .andExpect(jsonPath("$.count").value(492));
  }
}
