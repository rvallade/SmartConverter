package com.apps.romain.smartconverter.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TemperatureConverter extends Converter {
    private boolean celciusToFarenheit = false;

    public TemperatureConverter(boolean celToFar) {
        super();
        celciusToFarenheit = celToFar;
    }

    @Override
    public BigDecimal convertir(BigDecimal valueToConvert, Converter to) {
        BigDecimal result;
        if (celciusToFarenheit){
            result = valueToConvert.multiply(new BigDecimal("1.8")).add(new BigDecimal("32"));
        } else {
            result = valueToConvert.subtract(new BigDecimal("32")).multiply(new BigDecimal("5")).divide(new BigDecimal("9"), 2, RoundingMode.HALF_UP);
        }
        result.setScale(2, RoundingMode.HALF_UP);
        // on renvoit le resultat arrondit a 2 decimales
        return result;
    }
}
