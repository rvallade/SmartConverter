package com.apps.romain.smartconverter;

/**
 * Created by Romain on 07/02/2016.
 */
public enum ConvertType {
    DISTANCE("DISTANCE", R.array.listDistances),
    VOLUME("VOLUME", R.array.listVolumes),
    POIDS("POIDS", R.array.listPoids),
    TEMPERATURE("TEMPERATURE", R.array.listTemperatures);

    private String name;
    private int listOfUnits;

    ConvertType(String name, int listOfUnits) {
        this.name = name;
        this.listOfUnits = listOfUnits;
    }

    public int getListOfUnits() {
        return listOfUnits;
    }
}
