package com.apps.romain.smartconverter;

/**
 * Created by Romain on 08/02/2016.
 */
public class SpinnerItem {
    private String label;
    private String value;

    public SpinnerItem(String value, String label) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
