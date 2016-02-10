package com.apps.romain.smartconverter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Romain on 08/02/2016.
 */
public class MySpinnerAdapter extends ArrayAdapter<SpinnerItem> {
    private Context context;
    private SpinnerItem[] myObjs;

    public MySpinnerAdapter(Context context, int textViewResourceId, SpinnerItem[] myObjs) {
        super(context, textViewResourceId);
        this.context = context;
        this.myObjs = myObjs;
    }

    @Override
    public int getCount() {
        return myObjs.length;
    }

    @Override
    public SpinnerItem getItem(int position) {
        return myObjs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getLabel());
        label.setTextColor(Color.WHITE);
        label.setTextSize(40f);
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs[position].getLabel());
        label.setTextColor(Color.BLACK);
        label.setPadding(10,0,5,20);
        label.setTextSize(20f);
        return label;
    }
}
