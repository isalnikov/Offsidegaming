package com.isalnikov.offsidegaming.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import com.isalnikov.offsidegaming.repository.ClientRepository;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author isalnikov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {
//TODO нужент тестовый контекст 
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private ClientRepository clientRepository;

    @Autowired
    ClientController clientController;

    @Autowired
    private MockMvc mockMvc;

    
    
    @Test
    public void whenGet() throws Exception {
       
        Client client = new Client();
        client.setId(1L);
        DeviceData data = new DeviceData(1L, 1L, 1L);
        data.setId(1L);
        client.addValue(data);
        
//      when(clientRepository.findAllDataByClientId(1L))
//                .thenReturn(client);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/get/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_VALUE));
    }
    
    @Test
    public void whenPost() throws Exception {
        String jsonString = "{\"gas\" : 1000, \"cold\" :2000, \"hot\" : 3000}";
        

        
        mockMvc.perform(MockMvcRequestBuilders.post("/add/1")
                .content(jsonString)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_VALUE));
    }
 

}
