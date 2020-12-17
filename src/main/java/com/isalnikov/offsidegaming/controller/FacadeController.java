package com.isalnikov.offsidegaming.controller;

/**
 *
 * @author isalnikov
 */
import org.springframework.web.bind.annotation.*;

@RestController
public class FacadeController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void disableFavicon() {

    }
}
