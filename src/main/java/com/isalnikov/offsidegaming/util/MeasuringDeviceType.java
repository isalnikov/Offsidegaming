package com.isalnikov.offsidegaming.util;

/**
 *
 * @author isalnikov
 */
public enum MeasuringDeviceType {
    GAS(1), COLD_WATER(2), HOT_WATER(3);
    
    private final int type;

    MeasuringDeviceType(int type) {
        this.type = type;
    }

}
