package com.apps.romain.smartconverter.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Romain on 07/07/2016.
 */
public class ConsommationConverter extends Converter {
    private final static BigDecimal CONSUMPTION_FACTOR = new BigDecimal("235.215");

    public ConsommationConverter() {
        super();
    }

    @Override
    public BigDecimal convertir(BigDecimal valueToConvert, Converter to) {
        // specific use-case if the value to convert is 0 then we return 0
        if (valueToConvert.intValue() == 0) {
            return BigDecimal.ZERO;
        }
        // easy, just need to multiply by 235.215
        CONSUMPTION_FACTOR.setScale(2, RoundingMode.HALF_UP);
        return CONSUMPTION_FACTOR.divide(valueToConvert, 2, RoundingMode.HALF_UP);
    }
}
