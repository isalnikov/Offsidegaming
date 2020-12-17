
package com.isalnikov.offsidegaming.repository;

import com.isalnikov.offsidegaming.model.Client;
import javax.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
/**
 *
 * @author isalnikov
 */
@Log4j2
@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {
    
    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testSomeMethod() {
        clientRepository.save(new Client());
        Client fromDb = clientRepository.getOne(1L);
        log.info(fromDb);
        assertEquals(fromDb.getId(),1L);
    }
    
}
