package com.gashe.listadelacompra;

import android.app.Activity;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String[] listaArray;
    private boolean[] clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cargamos array verificando si está guardado en el bundle o no
        listaArray = getResources().getStringArray(R.array.lista_compra);
        if (savedInstanceState != null) {
            clicks = savedInstanceState.getBooleanArray("clicks");
        }else{
            clicks = new boolean[listaArray.length];
            Arrays.fill(clicks, false);
        }

        //creamos adaptador y asociamos layout
        ListaAdapter adaptador = new ListaAdapter(this, listaArray, clicks);
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adaptador);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Controlamos la selección y deselección
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Guardo el array de clicks en el bundle
        outState.putBooleanArray("clicks", clicks);
        super.onSaveInstanceState(outState);
    }
}
