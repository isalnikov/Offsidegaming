package com.isalnikov.offsidegaming.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author isalnikov
 */
@Log4j2
public class DeviceDataTest {

    private static Validator validator;

   private static final  ObjectMapper objectMapper = new ObjectMapper();
    
    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    public void testDeviceDataObjectMapper() throws JsonProcessingException {
        DeviceData data = new DeviceData(1000L, 2000L, 3000L);
        String value = objectMapper.writeValueAsString(data);
        log.info(value);
        String jsonString = "{ \"gas\" : 1000, \"cold\" :2000, \"hot\" : \"3000\" }";
        DeviceData data1 = objectMapper.readValue(jsonString, DeviceData.class);
        assertEquals(data, data1);
        log.info(data1);
    }
    
    @Test
    public void testDeviceDataSuccess() {
        DeviceData contact = new DeviceData(1000L, 2000L, 3000L);
        Set<ConstraintViolation<DeviceData>> violations = validator.validate(contact);
        assertTrue(violations.isEmpty());

    }

    @Test
    public void testDeviceDataFalse() {
        DeviceData data1 = new DeviceData(1000L, -2000L, 3000L);
        Set<ConstraintViolation<DeviceData>> violations = validator.validate(data1);
        assertFalse(violations.isEmpty());
        log.info(violations.iterator().next().getMessage());
    }

    @Test
    public void testDeviceDataEquals() {
        DeviceData data1 = new DeviceData(-1000L, -2000L, -3000L);
        Set<ConstraintViolation<DeviceData>> violations = validator.validate(data1);
        assertEquals(3, violations.size());

    }

    @Test
    public void testToString() {
        DeviceData deviceData = new DeviceData(1000L, 2000L, 3000L);
        log.info(deviceData);

    }
    
    @Test
    public void testCompareToDeviceData() {
        log.info(Integer.compare(4, 5));//-1 4 < 5
        log.info(Integer.compare(5, 5));//0  5 = 5
        log.info(Integer.compare(5, 4));//1  5 > 4
        DeviceData deviceData1 = new DeviceData(1000L, 2000L, 3000L);
        DeviceData deviceData2 = new DeviceData(2000L, 3000L, 4000L);
        
        int compareTo = deviceData1.compareTo(deviceData2);
        log.info(compareTo);
        assertEquals(compareTo, -1);
        
        DeviceData deviceData3 = new DeviceData(1000L, 2000L, 3000L);
        DeviceData deviceData4 = new DeviceData(100L, 200L, 400L);
        
        compareTo = deviceData3.compareTo(deviceData4);
        log.info(compareTo);
        assertEquals(compareTo, 1);
    }
    
    
    @Test
    public void testWriterWithDefaultPrettyPrinter() {
        String json = null;
        try {
            ObjectNode help = objectMapper.createObjectNode();
            help.put("GET ", "curl http://localhost:8888/getDataByPersionId/{clientId}");
            help.put("POST", "curl -i -X POST -H \"Content-Type: application/json\" -d '{\"gas\":1, \"cold\":1, \"hot\":1 }' http://localhost:8888/addData/{clientId}");
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(help);
        } catch (JsonProcessingException exception) {
            json = exception.getMessage();
        }

        log.info(json);
    }
}
