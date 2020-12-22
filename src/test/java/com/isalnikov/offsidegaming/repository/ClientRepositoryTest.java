package com.isalnikov.offsidegaming.repository;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author isalnikov
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRepositoryTest {

   @MockBean
    private ClientRepository clientRepository;

    @Test
    public void testSaveClient() {

        Client client = new Client();
        client.setId(1L);
        DeviceData data = new DeviceData(1L, 1L, 1L);
        data.setId(1L);
        client.addValue(data);

        when(clientRepository.save(client))
                .thenReturn(client);

        when(clientRepository.getOne(1L))
                .thenReturn(client);

        clientRepository.save(client);

        client = clientRepository.getOne(1L);

        assertEquals(client.getId(), 1L);
    }


}
