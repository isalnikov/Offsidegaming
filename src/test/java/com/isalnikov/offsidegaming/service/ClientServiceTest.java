package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author isalnikov
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;


    @Test
    public void testSaveClient() {
         Client client  = new Client();
         client.addValue(new DeviceData(1L, 2L, 3L));
         client.addValue(new DeviceData(4L, 5L, 6L));
         
         client =  clientService.save(client);
         

    }

    @Test
    public void testCacheable() {
//TODO для полноценных  Mockito тестов нужен тестовый контекст 
//        Client client = new Client();
//        client.setId(1L);
//        DeviceData data = new DeviceData(1L, 1L, 1L);
//        data.setId(1L);
//        client.addValue(data);
//
//        when(clientService.findAllDataByClientId(1L))
//                .thenReturn(client);


       

        clientService.findAllDataByClientId(1L);
        clientService.findAllDataByClientId(1L);


        
     //  Mockito.verify(clientService, Mockito.times(1)).findAllDataByClientId(1L);

    }
}
