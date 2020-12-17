package com.isalnikov.offsidegaming;


import com.isalnikov.offsidegaming.controller.FacadeController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 *
 * @author isalnikov
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainTest {

    private static final Logger logger = LogManager.getLogger(FacadeController.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

//    @Test
//    public void hello() {
//        logger.info("rr");
//    }
//
//    @Test
//    public void greetingShouldReturnDefaultMessage() throws Exception {
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
//                String.class)).contains("Hello, World");
//    }
}
