package com.isalnikov.offsidegaming.controller;

/**
 *
 * @author isalnikov
 */

import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class FacadeController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
