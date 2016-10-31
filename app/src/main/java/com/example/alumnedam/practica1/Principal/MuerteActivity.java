package com.example.alumnedam.practica1.Principal;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumnedam.practica1.R;
import com.example.alumnedam.practica1.Utilitys.CalcularMuerte;

public class MuerteActivity extends AppCompatActivity {
    //Declaramos como global frase para poder tener la frase en
    // todo momento tambien por si salta un reinicio de eventos
    private String frase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muerte);
        //Metemos en variables nombre, edad, y vicios
        String nombre = getIntent().getStringExtra("nombre");
        int edad = getIntent().getIntExtra("edad", -33);
        boolean cbDrogas = getIntent().getBooleanExtra("cbDrogas", false);
        boolean cbAlcohol = getIntent().getBooleanExtra("cbAlcohol", false);
        boolean cbMujHom = getIntent().getBooleanExtra("cbMujHom", false);
        //Declaramos y llamamos a CalcularMuerte para obtener un resultado
        CalcularMuerte cm = new CalcularMuerte();
        int edadMuerte = cm.calculaMuerte(edad, cbDrogas, cbAlcohol, cbMujHom);
        //Declaramos el TextView
        TextView tvTexto = (TextView) findViewById(R.id.tvMuerte);
        //Declaramos un array de strings
        String[] mensajesMuerte;
        //El array de strings le decimos que contendra las frases del .xml muerte
        mensajesMuerte = getResources().getStringArray(R.array.muerte);
        //Hacemos un Random con la longitud maxima del array
        int num = (int) Math.floor(Math.random() * (mensajesMuerte.length - 0) + 0);
        //Declaramos frase como string con el nombre, el mensaje que saldra con el random, los años con los que muere
        frase = (nombre + " " + mensajesMuerte[num] + " " + edadMuerte + " años");
        //En caso de haber rotado la pantalla, o otro evento que reinicie la activity, se recurre al guardado que teniamos.
        if (savedInstanceState != null) {
            frase = savedInstanceState.getString("frase");
        }
        //Se aplica la frase a el textView
        tvTexto.setText(frase);
    }
    //Metodo para guardar como esta la app en caso de rotacion u otro evento que haga un reinicio de este
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("frase", frase);
        super.onSaveInstanceState(outState);
    }



}

