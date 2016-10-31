package com.example.alumnedam.practica1.Principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.alumnedam.practica1.R;
import com.example.alumnedam.practica1.Utilitys.CalcularMuerte;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCallActivity = (Button) findViewById(R.id.btnCalcula);
        btnCallActivity.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MuerteActivity.class);
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etEdad = (EditText) findViewById(R.id.etEdad);
        int edad =  Integer.parseInt(etEdad.getText().toString());
        intent.putExtra("nombre", etNombre.getText().toString());
        intent.putExtra("edad", edad);
        startActivity(intent);
    }
}
