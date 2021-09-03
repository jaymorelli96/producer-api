package com.example.producerapi.controller;

import com.example.producerapi.dto.FavoriteDTO;
import com.example.producerapi.service.FavoriteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ProducerRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private FavoriteService service;

    @Test
    void sendToRabbit() throws Exception {

        FavoriteDTO fav = new FavoriteDTO();

        //Arrange
        doNothing().when(service).sendFavoriteToRabbit(any(FavoriteDTO.class));

        //Act
        mockMvc.perform(MockMvcRequestBuilders.post("/api/favorites")
                .content(new ObjectMapper().writeValueAsString(fav))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        //Assert
                .andExpect(status().is2xxSuccessful()).andDo(print());


    }
}