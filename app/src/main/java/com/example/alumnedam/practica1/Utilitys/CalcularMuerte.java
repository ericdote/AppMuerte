package com.example.alumnedam.practica1.Utilitys;

import android.widget.CheckBox;

import com.example.alumnedam.practica1.R;

import java.util.Random;

/**
 * Created by ALUMNEDAM on 13/10/2016.
 */

public class CalcularMuerte {


    public int calculaMuerte(int Edad, boolean droga, boolean alco, boolean mujhom) {
        Random rnd = new Random();
        int edad;
        do {
            edad = (rnd.nextInt((100 - Edad) + Edad));
            if (droga) {
                edad = edad - 10;
            }
            if (alco) {
                edad = edad - 5;
            }
            if (mujhom) {
                edad = edad - 2;
            }
        } while (edad < Edad);
        return edad;
    }
}
