package com.gashe.listadelacompra;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.support.v7.appcompat.R.id.top;

/**
 * Created by Gashe on 24/1/17.
 */

public class ListaAdapter extends BaseAdapter{

    private Context ct;
    private String[] listaArray;
    private boolean[] clicks;

    public ListaAdapter(Context context, String[] listaArray, boolean[] clicks) {
        this.ct = context;
        this.listaArray = listaArray;
        this.clicks = clicks;
    }

    @Override
    public int getCount() {
        return listaArray.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        TextView textView;
        if(view == null){
            textView = new TextView(ct);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
            textView.setGravity(Gravity.CENTER_VERTICAL);
        }else{
            textView = (TextView) view;
        }

        if(clicks[i]){
            textView.setBackgroundColor(Color.CYAN);
        }else{
            textView.setBackgroundColor(Color.WHITE);
        }

        textView.setText(listaArray[i]);

        return textView;

    }

}
