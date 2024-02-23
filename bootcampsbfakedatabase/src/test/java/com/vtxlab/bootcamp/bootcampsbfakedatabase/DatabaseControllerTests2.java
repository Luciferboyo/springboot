package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@WebMvcTest(DatabaseController.class)//Inject the web layer related bean to context only.
//sb,in this test env,component scan will ignore @Service,@Configuration,etc.
//but includes controller bean, mockmvc beans,etc.
public class DatabaseControllerTests2 {
  
  @Autowired
  private MockMvc mockMvc;

   @Autowired
    private ObjectMapper objectMapper;

  //@Autowired//you can not autowired service bean in WebMvcTest env.
  @MockBean
  private CatDatabaseService catDatabaseService;

  @Test
  void testGetCat() throws Exception{
    //assumption
    Cat mockedReturnCat = new Cat("ABCD",3);
    //when
    Mockito.when(catDatabaseService.getFromStaticMemory(1)).thenReturn(mockedReturnCat);

    //assert
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/cat/{idx}","1"))
    .andExpect(MockMvcResultMatchers.status().isOk())//http code 200 - ok
    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ABCD"))
    .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(3))
    .andDo(MockMvcResultHandlers.print());

    //wrong path
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/cat2/{idx}","1"))
    .andExpect(MockMvcResultMatchers.status().isNotFound())
    .andDo(MockMvcResultHandlers.print());

    Mockito.when(catDatabaseService.deleteCat(3)).thenReturn(new Cat("Mary", 1));
    //deleteCat
    mockMvc.perform(MockMvcRequestBuilders.delete("/api/v2/cat/{idx}",1))
    .andExpect(MockMvcResultMatchers.status().isOk())//http code 200 - ok
    .andExpect(MockMvcResultMatchers.jsonPath("$").value(false))
    .andDo(MockMvcResultHandlers.print());
    

    //post
    Cat cat =  new Cat("NewCat", 2);

    Mockito.when(catDatabaseService.updateCatToStaticMemry(2,cat)).thenReturn(cat);
    
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/cat/{idx}",5)
    .contentType("application/json")
    .content(objectMapper.writeValueAsString(cat)))
    .andExpect(MockMvcResultMatchers.status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NewCat"))
    .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(2))
    .andDo(MockMvcResultHandlers.print());
  }
}
