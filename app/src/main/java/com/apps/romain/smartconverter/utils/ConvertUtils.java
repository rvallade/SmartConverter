package com.apps.romain.smartconverter.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

public class ConvertUtils {
    private static HashMap<String, Converter> mapConvert = null;
    private final static String MASQUE = "#0.#################";

    public static void initMap(){
        if (mapConvert == null){
            mapConvert = new HashMap<>();
            // distances
            mapConvert.put("CM", new Converter("0.01", "100"));
            mapConvert.put("M", new Converter("1", "1"));
            mapConvert.put("KM", new Converter("1000", "0.001"));
            mapConvert.put("IN", new Converter("0.0254", "39.37007874015748"));
            mapConvert.put("FT", new Converter("0.3048", "3.280839895013123"));
            mapConvert.put("YD", new Converter("0.9144", "1.093613298337708"));
            mapConvert.put("MI", new Converter("1609.344", "0.000621371192237334"));
            // volumes
            mapConvert.put("M3", new Converter("1000", "0.001"));
            mapConvert.put("TBSP", new Converter("0.0147867648437", "67.6280451178"));
            mapConvert.put("OZFL", new Converter("0.0295735295625", "33.814022701843"));
            mapConvert.put("TSP", new Converter("0.00492892161458", "202.884135354"));
            mapConvert.put("CUP", new Converter("0.2365882375", "4.22675281986"));
            mapConvert.put("GAL", new Converter("3.785411784", "0.2641720523581484"));
            mapConvert.put("ML", new Converter("0.001", "1000"));
            mapConvert.put("L", new Converter("1", "1"));
            mapConvert.put("FT3", new Converter("28.316846592", "0.0353146667214886"));
            // poids
            mapConvert.put("G", new Converter("1", "1"));
            mapConvert.put("KG", new Converter("1000", "0.001"));
            mapConvert.put("P", new Converter("453.59237", "0.0022046226218488"));
            mapConvert.put("OZ", new Converter("28.349523125", "0.0352739619495804"));
            // temperatures
            mapConvert.put("C", new TemperatureConverter(true));
            mapConvert.put("F", new TemperatureConverter(false));
            // surface
            mapConvert.put("M2", new Converter("1", "1"));
            mapConvert.put("HA", new Converter("10000", "0.0001"));
            mapConvert.put("FT2", new Converter("0.092903", "10.7639"));
            mapConvert.put("ACRE", new Converter("4046.86", "0.000247105"));
            // consommation
            mapConvert.put("L100", new ConsommationConverter());
            mapConvert.put("MG", new ConsommationConverter());
        }
    }

    public static Converter getConverterFromSelectedText(String key){
        return mapConvert.get(key);
    }

    private static String getStringFromBigDecimal(BigDecimal valueToConvert) {
        DecimalFormat df = new DecimalFormat(MASQUE);
        return df.format(valueToConvert.setScale(8, BigDecimal.ROUND_HALF_UP));
    }

    public static String convertir(BigDecimal valueToConvert, Converter from, Converter to) {
        if (from.equals(to)) {
            return getStringFromBigDecimal(valueToConvert);
        }

        return getStringFromBigDecimal(from.convertir(valueToConvert, to));
    }
}
