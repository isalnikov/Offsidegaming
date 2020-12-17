package com.isalnikov.offsidegaming.repository;

import com.isalnikov.offsidegaming.model.Client;
import java.io.IOException;
import javax.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testGetByIdClient() {
        exceptionRule.expect(javax.persistence.EntityNotFoundException.class);
        exceptionRule.expectMessage("For input string");

        Client client = clientRepository.getOne(1L);
        log.info(client);

    }

}
