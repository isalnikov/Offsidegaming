package com.isalnikov.offsidegaming.controller;

/**
 *
 * @author isalnikov
 */
import com.isalnikov.offsidegaming.model.DeviceData;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class ClientController {

    @GetMapping("/")
    String home() {
        log.info("Hello");
        return "Hello World!";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void disableFavicon() {
    }

    @PostMapping(value = "/data")
    public ResponseEntity addData(
            @RequestParam(value = "id") Long id,
            @Valid @RequestBody DeviceData deviceData) {
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
