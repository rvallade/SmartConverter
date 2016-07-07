package com.apps.romain.smartconverter.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {
    protected BigDecimal valueInReference = null;
    protected BigDecimal equivalentInReference = null;

    public Converter(String valueInReference, String equivalentInReference) {
        if (valueInReference != null) {
            this.valueInReference = new BigDecimal(valueInReference);
        }
        if (equivalentInReference != null) {
            this.equivalentInReference = new BigDecimal(equivalentInReference);
        }
    }
    public Converter() {
    }

    public BigDecimal convertir(BigDecimal valueToConvert, Converter to) {
        // to reference value
        BigDecimal result = valueToConvert.multiply(this.getValueInReference());
        // to the selected unit
        result.setScale(2, RoundingMode.HALF_UP);
        return result.multiply(to.getEquivalentInReference());
    }
    
    public BigDecimal getValueInReference() {
        return valueInReference;
    }

    public BigDecimal getEquivalentInReference() {
        return equivalentInReference;
    }
}
