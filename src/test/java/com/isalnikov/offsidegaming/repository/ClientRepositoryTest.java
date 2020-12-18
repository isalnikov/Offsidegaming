package com.isalnikov.offsidegaming.repository;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import javax.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.rules.ExpectedException;

/**
 *
 * @author isalnikov
 */
@Log4j2
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(Transactional.TxType.NOT_SUPPORTED)
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testSaveClient() {
        clientRepository.save(new Client());
        Client client = clientRepository.getOne(1L);
        log.info(client);
        assertEquals(client.getId(), 1L);
    }
    @Test
    public void testAddData() {

        Client client = new Client();
        client.addValue(new DeviceData(1L, 2L, 3L));
        client.addValue(new DeviceData(4L, 5L, 6L));
        clientRepository.save(client);
        client = clientRepository.getOne(1L);
        log.info(client);
        assertEquals(client.getId(), 1);
        assertEquals(client.getValues().size(), 2);
        for (DeviceData value : client.getValues()) {
             log.info(value);
        }

    }

}
