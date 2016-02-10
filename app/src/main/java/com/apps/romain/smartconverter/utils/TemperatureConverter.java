package com.apps.romain.smartconverter.utils;

import java.math.BigDecimal;

public class TemperatureConverter extends Converter {
    private boolean celciusToFarenheit = false;

    public TemperatureConverter(boolean celToFar) {
        super();
        celciusToFarenheit = celToFar;
    }
    
    public String convertir(BigDecimal valueToConvert) {
        float result;
        
        if (celciusToFarenheit){
            result = (valueToConvert.floatValue() * 1.8f)+ 32f;
        } else {
            result = (valueToConvert.floatValue() - 32f)*5/9;
        }
        
        result = Float.parseFloat(Double.toString(Math.floor((result * 100.0f) + 0.5f)))/100;
        
        // on renvoit le resultat arrondit a 2 decimales
        return Float.toString(result);
    }
}
