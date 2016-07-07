package com.apps.romain.smartconverter;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.apps.romain.smartconverter.utils.ConvertUtils;
import com.apps.romain.smartconverter.utils.Converter;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    TextView zone1 = null;
    TextView zone2 = null;
    Spinner units1 = null;
    Spinner units2 = null;
    Button distances;
    Button poids;
    Button volumes;
    Button temperatures;
    Button surfaces;
    Button consommations;
    boolean isDirect = true;
    boolean deleteTextViewContent = true;
    String textToConvert = null;
    ConvertType selectedConvertType;
    String selectedUnitFromUnit1;
    String selectedUnitFromUnit2;
    SpinnerItem[] distanceSpinnerItems = {
            new SpinnerItem("M", "m"),
            new SpinnerItem("CM", "cm"),
            new SpinnerItem("KM", "km"),
            new SpinnerItem("IN", "in"),
            new SpinnerItem("FT", "ft"),
            new SpinnerItem("YD", "yd"),
            new SpinnerItem("MI", "mi"),
    };
    SpinnerItem[] weightSpinnerItems = {
            new SpinnerItem("G", "g"),
            new SpinnerItem("KG", "kg"),
            new SpinnerItem("P", "lb"),
            new SpinnerItem("OZ", "oz"),
    };
    SpinnerItem[] volumesSpinnerItems = {
            new SpinnerItem("ML", "ml"),
            new SpinnerItem("L", "l"),
            new SpinnerItem("M3", "m3"),
            new SpinnerItem("TBSP", "tbsp"),
            new SpinnerItem("OZFL", "oz fl"),
            new SpinnerItem("TSP", "tsp"),
            new SpinnerItem("CUP", "cup"),
            new SpinnerItem("GAL", "gal"),
            new SpinnerItem("FT3", "fl3"),
    };
    SpinnerItem[] temperatureSpinnerItems = {
            new SpinnerItem("C", "C"),
            new SpinnerItem("F", "F")
    };
    SpinnerItem[] surfacesSpinnerItems = {
            new SpinnerItem("M2", "m²"),
            new SpinnerItem("HA", "ha"),
            new SpinnerItem("FT2", "ft²"),
            new SpinnerItem("ACRE", "acre")
    };
    SpinnerItem[] consommationsSpinnerItems = {
            new SpinnerItem("L100", "l/100"),
            new SpinnerItem("MG", "mpg")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zone1 = (TextView) findViewById(R.id.zone1);
        zone2 = (TextView) findViewById(R.id.zone2);
        units1 = (Spinner) findViewById(R.id.units1);
        units2 = (Spinner) findViewById(R.id.units2);
        distances = (Button) findViewById(R.id.buttonD);
        poids = (Button) findViewById(R.id.buttonW);
        volumes = (Button) findViewById(R.id.buttonV);
        temperatures = (Button) findViewById(R.id.buttonT);
        surfaces = (Button) findViewById(R.id.buttonS);
        consommations = (Button) findViewById(R.id.buttonC);

        ConvertUtils.initMap();

        initializeListeners();
        initSpinner(distanceSpinnerItems);

        zone1.setText("0");
        zone2.setText("0");
        textToConvert = "0";
        handleTextViewChangeFocus(zone1, zone2, true);
        distances.setBackgroundResource(R.drawable.button_green);
        selectedConvertType = ConvertType.DISTANCE;
    }

    private void initializeListeners() {
        zone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // zone1 bold, zone2 normal
                handleTextViewChangeFocus(zone1, zone2, true);
            }
        });

        zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // zone1 bold, zone2 normal
                handleTextViewChangeFocus(zone2, zone1, false);
            }
        });

        Button button0 = (Button) findViewById(R.id.button0);
        addOnClickListenerToKeyBoardButton(button0, "0", true);

        Button button1 = (Button) findViewById(R.id.button1);
        addOnClickListenerToKeyBoardButton(button1, "1", true);

        Button button2 = (Button) findViewById(R.id.button2);
        addOnClickListenerToKeyBoardButton(button2, "2", true);

        Button button3 = (Button) findViewById(R.id.button3);
        addOnClickListenerToKeyBoardButton(button3, "3", true);

        Button button4 = (Button) findViewById(R.id.button4);
        addOnClickListenerToKeyBoardButton(button4, "4", true);

        Button button5 = (Button) findViewById(R.id.button5);
        addOnClickListenerToKeyBoardButton(button5, "5", true);

        Button button6 = (Button) findViewById(R.id.button6);
        addOnClickListenerToKeyBoardButton(button6, "6", true);

        Button button7 = (Button) findViewById(R.id.button7);
        addOnClickListenerToKeyBoardButton(button7, "7", true);

        Button button8 = (Button) findViewById(R.id.button8);
        addOnClickListenerToKeyBoardButton(button8, "8", true);

        Button button9 = (Button) findViewById(R.id.button9);
        addOnClickListenerToKeyBoardButton(button9, "9", true);

        Button buttonPoint = (Button) findViewById(R.id.buttonPoint);
        addOnClickListenerToKeyBoardButton(buttonPoint, ".", false);

        Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textToConvert.contains("-")) {
                    textToConvert = textToConvert.replace("-", "");
                } else {
                    textToConvert = "-" + textToConvert;
                }
                deleteTextViewContent = false;
                getActiveTextView().setText(textToConvert);
                doConvert();
            }
        });
        buttonMinus.setEnabled(false);

        Button buttonCE = (Button) findViewById(R.id.buttonCE);
        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zone1.setText("0");
                zone2.setText("0");
                deleteTextViewContent = false;
                textToConvert = "0";
                doConvert();
            }
        });
        Button buttonDEL = (Button) findViewById(R.id.buttonDEL);
        buttonDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastCharOfTextViewWithFocus();
                doConvert();
            }
        });

        Button buttonSwitch = (Button) findViewById(R.id.buttonSwitch);
        buttonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // just switch units
                int units2Selection = units2.getSelectedItemPosition();
                int units1Selection = units1.getSelectedItemPosition();
                units2.setSelection(units1Selection);
                units1.setSelection(units2Selection);
            }
        });

        addOnClickListenerForConvertTypeButton(distances, ConvertType.DISTANCE, distanceSpinnerItems, false);
        addOnClickListenerForConvertTypeButton(poids, ConvertType.POIDS, weightSpinnerItems, false);
        addOnClickListenerForConvertTypeButton(volumes, ConvertType.VOLUME, volumesSpinnerItems, false);
        addOnClickListenerForConvertTypeButton(temperatures, ConvertType.TEMPERATURE, temperatureSpinnerItems, true);
        addOnClickListenerForConvertTypeButton(surfaces, ConvertType.SURFACE, surfacesSpinnerItems, false);
        addOnClickListenerForConvertTypeButton(consommations, ConvertType.CONSOMMATION, consommationsSpinnerItems, false);

        units1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedUnitFromUnit1 = ((SpinnerItem) parentView.getItemAtPosition(position)).getValue();
                doConvert();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

        units2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                selectedUnitFromUnit2 = ((SpinnerItem) parentView.getItemAtPosition(position)).getValue();
                doConvert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void removeLastCharOfTextViewWithFocus() {
        // we need to remove the last entry of either zone1 or zone2
        deleteTextViewContent = false;
        if (textToConvert.length() == 1 && !"-".equals(textToConvert)) {
            textToConvert = "";
        } else if (textToConvert.length() > 0 && !"-".equals(textToConvert)) {
            textToConvert = textToConvert.substring(0, textToConvert.length() - 1);
        } else if (textToConvert.contains("-")) {
            textToConvert = "-";
        }

        getActiveTextView().setText(textToConvert);
    }

    private void addOnClickListenerToKeyBoardButton(Button button, final String charToAdd, final boolean removeSingleZero) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumberToCorrectTextView(charToAdd, removeSingleZero);
                doConvert();
            }
        });
    }

    private void addOnClickListenerForConvertTypeButton(Button button, final ConvertType convertType, final SpinnerItem[] items, final boolean enableMinus) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // need to change the list of units
                if(!selectedConvertType.equals(convertType)) {
                    initSpinner(items);
                    selectedConvertType = convertType;
                }
                // change button background to black
                setDefaultBackgroundForAllConvertTypeButtons();
                // change background for current button to green
                v.setBackgroundResource(R.drawable.button_green);

                // button minus
                Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
                buttonMinus.setEnabled(enableMinus);
                if (!enableMinus) {
                    textToConvert = textToConvert.replace("-", "");
                    getActiveTextView().setText(textToConvert);
                }

                doConvert();
            }
        });
    }
    private TextView getActiveTextView() {
        return isDirect ? zone1 : zone2;
    }

    private TextView getInactiveTextView() {
        return isDirect ? zone2 : zone1;
    }

    private void setDefaultBackgroundForAllConvertTypeButtons() {
        distances.setBackgroundResource(R.drawable.button_black);
        volumes.setBackgroundResource(R.drawable.button_black);
        temperatures.setBackgroundResource(R.drawable.button_black);
        poids.setBackgroundResource(R.drawable.button_black);
        consommations.setBackgroundResource(R.drawable.button_black);
        surfaces.setBackgroundResource(R.drawable.button_black);
    }

    private void addNumberToCorrectTextView(String charToAdd, boolean removeSingleZero) {
        // in case we need to delete the content after having selected a new zone
        if (deleteTextViewContent) {
            zone1.setText("0");
            zone2.setText("0");
            deleteTextViewContent = false;
            textToConvert = "";
        }
        boolean isTextToConvertNegative = textToConvert.startsWith("-");

        String tempTextToConvert = textToConvert.replace("-", "");

        TextView activeTextView = getActiveTextView();
        boolean isEqualToZero = false;
        try {
            isEqualToZero = tempTextToConvert.length() == 1 && Double.parseDouble(tempTextToConvert) == 0;
        } catch (Exception e) {
            // do nothing
        }
        if (isEqualToZero && removeSingleZero) {
            tempTextToConvert = "";
        }

        if (tempTextToConvert.length() == 0 && charToAdd.equals(".")) {
            tempTextToConvert = "0";
        }

        if (!tempTextToConvert.contains(".") || !".".equals(charToAdd)) { // do not add a "." if there is already one
            tempTextToConvert += charToAdd;
            if (isTextToConvertNegative) {
                tempTextToConvert = "-" + tempTextToConvert;
            }
            activeTextView.setText(tempTextToConvert);
            textToConvert = tempTextToConvert;
        }
    }

    private void handleTextViewChangeFocus(TextView from, TextView to, boolean isDirectMode) {
        // do that only when we actually change the zone in focus
        if (from.getTypeface() == null || !from.getTypeface().isBold()) {
            from.setTypeface(null, Typeface.BOLD);
            to.setTypeface(null, Typeface.NORMAL);
            deleteTextViewContent = true;
            isDirect = isDirectMode;
            textToConvert = from.getText().toString();
        }
    }

    private void doConvert() {
        // here we need to convert based on what zone1 and zone2 contents and units1 and units2 selection
        if (textToConvert.length() > 0 && !"-".equals(textToConvert)) {
            Converter converterFrom = ConvertUtils.getConverterFromSelectedText(isDirect ? selectedUnitFromUnit1 : selectedUnitFromUnit2);
            Converter converterTo = ConvertUtils.getConverterFromSelectedText(isDirect ? selectedUnitFromUnit2 : selectedUnitFromUnit1);
            String result = ConvertUtils.convertir(new BigDecimal(textToConvert), converterFrom, converterTo);
            getInactiveTextView().setText(result);
        } else {
            getInactiveTextView().setText("");
        }
    }

    private void initSpinner(SpinnerItem[] items) {
        MySpinnerAdapter mySpinnerAdapter = new MySpinnerAdapter(this, R.layout.my_spinner, items);
        units1.setAdapter(mySpinnerAdapter);
        units2.setAdapter(mySpinnerAdapter);
        selectedUnitFromUnit1 = items[0].getValue();
        selectedUnitFromUnit2 = selectedUnitFromUnit1;
    }


}
