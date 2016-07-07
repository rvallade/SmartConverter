package com.apps.romain.smartconverter.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Romain on 07/07/2016.
 */
public class ConsommationConverter extends Converter {

    public ConsommationConverter() {
        super();
    }

    @Override
    public BigDecimal convertir(BigDecimal valueToConvert, Converter to) {
        // easy, just need to multiply by 235.215
        valueToConvert.setScale(2, RoundingMode.HALF_UP);
        return valueToConvert.multiply(new BigDecimal("235.215"));
    }
}
