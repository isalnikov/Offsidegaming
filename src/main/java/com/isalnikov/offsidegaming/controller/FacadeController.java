package com.isalnikov.offsidegaming.controller;

/**
 *
 * @author isalnikov
 */
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class FacadeController {

    private static final Logger logger = LogManager.getLogger(FacadeController.class);

    @RequestMapping("/")
    String home() {
        logger.info("Hello");
        return "Hello World!";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void disableFavicon() {
    }
}
