package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DatabaseController.class)// Inject the web layer related bean to context only.
// In this test env, component scan will ignore @Service, @Configuration, etc.
// but includes controller beans, mockmvc beans, etc.
public class DatabaseControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  // You cannot autowired service bean in WebMvcTest env.
  @MockBean // Because Controller Bean need to autowired catDatabaseService
  private CatDatabaseService catDatabaseService;

  @Test
  void testGetCat() throws Exception{
    //assumption
    Cat mockedReturnCat = new Cat("ABCD",3);
    //when
    Mockito.when(catDatabaseService.getFromStaticMemory(1)).thenReturn(mockedReturnCat);
    
    //assert
    mockMvc.perform(get("/api/v2/cat/{idx}","1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("ABCD"))
            .andExpect(jsonPath("$.age").value(3))
            .andDo(print());

    // wrong path
    mockMvc.perform(get("/api/v1/cat2/{idx}", "1")) //
    .andExpect(status().isNotFound()) // http code 200 - OK
    .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testPostCat() throws Exception{
    Cat catToPosCat = new Cat("John",2);
    String contentString = new ObjectMapper().writeValueAsString(catToPosCat);
    //when
    Mockito.when(catDatabaseService.setCatToStaticMemry(1, catToPosCat)).thenReturn(catToPosCat);
    //assert
    mockMvc.perform(post("/api/v2/cat/{idx}","1"));
  }
}
