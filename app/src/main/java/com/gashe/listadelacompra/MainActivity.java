package com.gashe.listadelacompra;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cargamos array
        String[] listaArray = getResources().getStringArray(R.array.lista_compra);
        final Boolean[] clicks = new Boolean[listaArray.length];
        Arrays.fill(clicks, false);

        //creamos adaptador y asociamos layout
        ListaAdapter adaptador = new ListaAdapter(this, listaArray, clicks);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adaptador);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(clicks[i]){
                    view.setBackgroundColor(Color.WHITE);
                    clicks[i] = false;
                }else {
                    view.setBackgroundColor(Color.CYAN);
                    clicks[i] = true;
                }
            }
        });

    }
}
