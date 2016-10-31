package com.example.alumnedam.practica1.Principal;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumnedam.practica1.R;
import com.example.alumnedam.practica1.Utilitys.CalcularMuerte;

public class MuerteActivity extends AppCompatActivity {

    private String frase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muerte);
        String nombre = getIntent().getStringExtra("nombre");
        int edad = getIntent().getIntExtra("edad", -33);
        boolean cbDrogas = getIntent().getBooleanExtra("cbDrogas", false);
        boolean cbAlcohol = getIntent().getBooleanExtra("cbAlcohol", false);
        boolean cbMujHom = getIntent().getBooleanExtra("cbMujHom", false);
        CalcularMuerte cm = new CalcularMuerte();
        int edadMuerte = cm.calculaMuerte(edad, cbDrogas, cbAlcohol, cbMujHom);
        TextView tvTexto = (TextView) findViewById(R.id.tvMuerte);
        String[] mensajesMuerte;
        mensajesMuerte = getResources().getStringArray(R.array.muerte);
        int num = (int) Math.floor(Math.random() * (mensajesMuerte.length - 0) + 0);
        frase = (nombre + " " + mensajesMuerte[num] + " " + edadMuerte + " años");
        if (savedInstanceState != null) {
            frase = savedInstanceState.getString("frase");
        }
        tvTexto.setText(frase);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("frase", frase);
        super.onSaveInstanceState(outState);
    }



}

