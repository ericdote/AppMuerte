package com.example.alumnedam.practica1.Utilitys;

import android.widget.CheckBox;

import com.example.alumnedam.practica1.R;

import java.util.Random;

/**
 * Created by ALUMNEDAM on 13/10/2016.
 */

public class CalcularMuerte {

    /**
     * Le llegan diferentes parametros
     * @param Edad la edad de la persona
     * @param droga si consume drogas
     * @param alco si consume alcohol
     * @param mujhom si es propenso a tener relaciones con hombres/mujeres
     * @return y devuelve una edad
     */
    public int calculaMuerte(int Edad, boolean droga, boolean alco, boolean mujhom) {
        //Inicializamos el random
        Random rnd = new Random();
        //Inicializamos la edad
        int edad;
        //Hacemos un do while, para que mientras la edad no sea mayor a la edad que ya tiene el usuario que no pare
        do {
            //Calculamos la edad de su muerte con un numero aleatorio
            edad = (rnd.nextInt((100 - Edad) + Edad));
            //Si es adicto le restamos 10 años
            if (droga) {
                edad = edad - 10;
            }
            //Si es alcoholico le restamos 5 años
            if (alco) {
                edad = edad - 5;
            }
            //Si es propenso a relaciones le restamos 2 años
            if (mujhom) {
                edad = edad - 2;
            }
        } while (edad < Edad);
        return edad;
    }
}
