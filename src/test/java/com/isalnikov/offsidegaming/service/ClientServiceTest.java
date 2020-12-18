
package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import lombok.extern.log4j.Log4j2;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        clientService.save(new Client());
        Client client = clientService.findById(1L).get();
        log.info(client);
        assertEquals(client.getId(), 1L);
        
        client.addValue(new DeviceData(1L, 2L, 3L));
        client.addValue(new DeviceData(4L, 5L, 6L));
        clientService.save(client);
        
        client = clientService.findById(1L).get();
        log.info(client);
        assertEquals(client.getId(), 1);
        assertEquals(client.getValues().size(), 2);
        for (DeviceData value : client.getValues()) {
             log.info(value);
        }
        
    }
}
