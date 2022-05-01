package com.example.educasen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class PantallaDeCarga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_carga);

        // Creamos el metodo que sirve para controlar el tiempo de carga y la redireccion al siguiente activity
        int Tiempo = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(PantallaDeCarga.this, MainActivity.class));
                finish();
            }
        }, Tiempo);
    }
}