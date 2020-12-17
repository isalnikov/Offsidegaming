package com.isalnikov.offsidegaming.controller;

/**
 *
 * @author isalnikov
 */
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class FacadeController {

    

    @RequestMapping("/")
    String home() {
        log.info("Hello");
        return "Hello World!";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void disableFavicon() {
    }
}
