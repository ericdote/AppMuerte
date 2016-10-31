package com.example.alumnedam.practica1.Principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumnedam.practica1.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializamos el boton y le aplicamos un Listener para cuando sea pulsado
        Button btnCallActivity = (Button) findViewById(R.id.btnCalcula);
        btnCallActivity.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcula) {
            //Declaramos donde se va a editar el texto (nombre y edad) y lo almacenamos
            EditText etNombre = (EditText) findViewById(R.id.etNombre);
            EditText etEdad = (EditText) findViewById(R.id.etEdad);
            CheckBox cbDrogas = (CheckBox) findViewById(R.id.cbDrogas);
            CheckBox cbAlcohol = (CheckBox) findViewById(R.id.cbAlcohol);
            CheckBox cbMujHom = (CheckBox) findViewById(R.id.cbMujHom);

            if (etNombre.getText().toString().equals("") && etEdad.getText().toString().equals("")){
                Toast.makeText (this, "Introdueix valors", Toast.LENGTH_LONG).show();

            } else {
                //Creamos un intent indicando donde enviaremos la informacion
                Intent intent = new Intent(this, MuerteActivity.class);
                //Creamos un int para pasar la edad de String a Int
                int edad = Integer.parseInt(etEdad.getText().toString());
                //Enviamos los valores
                intent.putExtra("nombre", etNombre.getText().toString());
                intent.putExtra("edad", edad);
                intent.putExtra("cbDrogas", cbDrogas.isChecked());
                intent.putExtra("cbAlcohol", cbAlcohol.isChecked());
                intent.putExtra("cbMujHom", cbMujHom.isChecked());
                //Damos paso a la otra activity
                startActivity(intent);
            }



        }
    }
}
