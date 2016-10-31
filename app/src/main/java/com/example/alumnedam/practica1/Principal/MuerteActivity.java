package com.example.alumnedam.practica1.Principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumnedam.practica1.R;
import com.example.alumnedam.practica1.Utilitys.CalcularMuerte;

public class MuerteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muerte);
        String nombre = getIntent().getStringExtra("nombre");
        int edad = getIntent().getIntExtra("edad", -33);
        CalcularMuerte cm = new CalcularMuerte();
        int edadMuerte = cm.calculaMuerte(edad);
        TextView tvTexto = (TextView) findViewById(R.id.tvMuerte);
        tvTexto.setText(nombre + " va a morir a los " + edadMuerte);

    }
}

