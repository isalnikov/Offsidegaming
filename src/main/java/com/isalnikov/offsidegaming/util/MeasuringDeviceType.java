package com.isalnikov.offsidegaming.util;

import java.util.EnumSet;
import java.util.Map;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author isalnikov
 */
public enum MeasuringDeviceType {
    NONE(0x000000),GAS(0x000001), COLD_WATER(0x000002), HOT_WATER(0x000003);

    private final long type;

    MeasuringDeviceType(long type) {
        this.type = type;
    }

    public long getType() {
        return type;
    }

      private static final Map<Long, MeasuringDeviceType> lookupByValue = EnumSet.allOf(MeasuringDeviceType.class)
            .stream()
            .collect(toMap(MeasuringDeviceType::getType, identity()));


    public static MeasuringDeviceType getByValue(Long count) {
        return lookupByValue.getOrDefault(count, NONE);
    }

    
}
