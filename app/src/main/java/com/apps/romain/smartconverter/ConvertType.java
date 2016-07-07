package com.apps.romain.smartconverter;

/**
 * Created by Romain on 07/02/2016.
 */
public enum ConvertType {
    DISTANCE("DISTANCE"),
    VOLUME("VOLUME"),
    POIDS("POIDS"),
    TEMPERATURE("TEMPERATURE"),
    SURFACE("SURFACE"),
    CONSOMMATION("CONSOMMATION");

    private String name;

    ConvertType(String name) {
        this.name = name;
    }
}
