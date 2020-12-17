//package com.isalnikov.offsidegaming.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.isalnikov.offsidegaming.model.Client;
//import com.isalnikov.offsidegaming.repository.ClientRepository;
//import java.nio.charset.Charset;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
///**
// *
// * @author isalnikov
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ClientControllerTest {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private ClientRepository clientRepository;
//
////    @Autowired
////    ClientController clientController;
//
////    @Autowired
////    private MockMvc mockMvc;
//
////    @Test
////    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
////        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
////        String jsonString = "{ \"gas\" : 1000, \"cold\" :2000, \"hot\" : \"3000\" }";
////        mockMvc.perform(MockMvcRequestBuilders.post("/data")
////                .content(jsonString)
////                .contentType(MediaType.APPLICATION_JSON_VALUE))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(MockMvcResultMatchers.content()
////                        .contentType(textPlainUtf8));
////    }
//    
//    
//       @Test
//    public void testGetById() {
//        
//        Client client = new Client();
//        client.setId(42L);
//        
//        given(this.clientRepository.getOne(any()))
//            .willReturn(client));
//        client = clientRepository.getOne(42L);
//        assertThat(client.getId()).isEqualTo(42);
//        // и какие-нибудь другие проверки
//    }
//
//}
