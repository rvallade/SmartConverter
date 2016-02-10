package com.apps.romain.smartconverter.utils;

import java.math.BigDecimal;

public class SpecialDistancesConverter extends Converter {
    public enum Conversion {METERS_IN_FEET_INCHES, FEET_INCHES_TO_METERS};
    private Conversion conversionType = null;
    
    public SpecialDistancesConverter(Conversion convertionType) {
        super(null, null);
        this.conversionType = convertionType;
    }
    
    /*@Override
    public String convertir(BigDecimal... valueToConvert) {
        BigDecimal result = null;
        if (Conversion.METERS_IN_FEET_INCHES.equals(conversionType)) {
            // need to convert m in cm, then cm in inches
            Converter cmToInches = ConvertUtils.getConverterFromSelectedText("cm => in");
            result = cmToInches.convertirToBigDecimal(valueToConvert[0].multiply(new BigDecimal(100)));
            // then in to ft
            BigDecimal feet = result.divide(new BigDecimal(12), 0, BigDecimal.ROUND_FLOOR);
            BigDecimal inches = result.remainder(new BigDecimal(12));
            return feet + " ft\r\n" + inches.setScale(2, BigDecimal.ROUND_HALF_UP) + " in";
            
        } else if (Conversion.FEET_INCHES_TO_METERS.equals(conversionType)) {
            // need to convert ft to m
            Converter converter = ConvertUtils.getConverterFromSelectedText("ft => m");
            result = converter.convertirToBigDecimal(valueToConvert[0]).multiply(new BigDecimal(100));
            // need to convert in to m
            converter = ConvertUtils.getConverterFromSelectedText("in => cm");
            result = result.add(converter.convertirToBigDecimal(valueToConvert[1]));
            return result.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP) + " m";
        }
        return null;
    }*/

    public Conversion getConversionType() {
        return conversionType;
    }
    
    
}
