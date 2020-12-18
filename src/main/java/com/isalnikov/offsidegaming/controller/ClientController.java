package com.isalnikov.offsidegaming.controller;

/**
 *
 * @author isalnikov
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import com.isalnikov.offsidegaming.service.ClientService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class ClientController {

    protected final ClientService clientService;

    protected static final ObjectMapper objectMapper = new ObjectMapper();

    protected static String json = null;

    @Autowired
    public ClientController(ClientService clientService) {
        Assert.notNull(clientService, "ClientService must be not null");
        this.clientService = clientService;

    }

    @GetMapping("/")
    String home() {

        if (json == null) {
            try {
                ObjectNode help = objectMapper.createObjectNode();
                help.put("GET", "curl http://localhost:8888/getDataByPersionId/{clientId}");
                help.put("POST", "curl -i -X POST  -H \"Content-Type: application/json\" -d '{\"gas\":1, \"cold\":1, \"hot\":1 }' http://localhost:8888/addData/{clientId}");
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(help);
            } catch (JsonProcessingException exception) {
                json = exception.getMessage();
            }

        }
        return json;
    }

    @GetMapping(value = "/getDataByPersionId/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getDataByPersionId(
            @PathVariable(value = "clientId") Long clientId) {

        Client client = clientService.findAllDataByClientId(clientId);

        return ResponseEntity.accepted().body(client);
    }

    @PostMapping(value = "/addData/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addData(
            @PathVariable(value = "clientId") Long clientId,
            @Valid @RequestBody DeviceData deviceData) {
          clientService.addNewData(clientId, deviceData);
         log.info(deviceData);

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
