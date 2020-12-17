package com.isalnikov.offsidegaming.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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

}
