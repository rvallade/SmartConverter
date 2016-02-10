package com.apps.romain.smartconverter.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Converter {
    public enum Operator {MULTIPLY, OPPOSITE_DIVIDE, DIVIDE};
    protected Operator operator = null;
    protected BigDecimal valueInReference = null;
    protected BigDecimal equivalentInReference = null;
    protected String label = null;

    public Converter(String valueInReference, String equivalentInReference) {
        if (valueInReference != null) {
            this.valueInReference = new BigDecimal(valueInReference);
        }
        if (equivalentInReference != null) {
            this.equivalentInReference = new BigDecimal(equivalentInReference);
        }
        //this.operator = operator;
    }
    public Converter() {
    }

    /*public String convertir(BigDecimal... valueToConvert) {
        DecimalFormat df = new DecimalFormat(masque);
        BigDecimal result = convertirToBigDecimal(valueToConvert[0]);
        return df.format(result.setScale(2, BigDecimal.ROUND_HALF_UP));
    }*/
    
    /*public BigDecimal convertirToBigDecimal(BigDecimal valueToConvert) {
        BigDecimal result = new BigDecimal("0");
        // on utilise l'operateur pour avoir le resultat
        if (Operator.MULTIPLY.equals(operator)) {
            result = valueToConvert.multiply(value);
        } else if (Operator.OPPOSITE_DIVIDE.equals(operator)){
            result = value.divide(valueToConvert, 8, BigDecimal.ROUND_HALF_UP);
        }
        return result;
    }*/
 
    public Operator getOperator() {
        return operator;
    }

    public BigDecimal getValueInReference() {
        return valueInReference;
    }

    public BigDecimal getEquivalentInReference() {
        return equivalentInReference;
    }
}
