package com.example.educasen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PantallaDeCarga extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_carga);

        //Inicializamos
        firebaseAuth = FirebaseAuth.getInstance();

        // Creamos el metodo que sirve para controlar el tiempo de carga y la redireccion al siguiente activity
        int Tiempo = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*startActivity(new Intent(PantallaDeCarga.this, MainActivity.class));
                finish();*/
                VerificarUsuario ();

            }
        }, Tiempo);
    }

    private void VerificarUsuario () {
        // Estamos obteniendo el usuario actual
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        //Condicion para saber si el usuario a iniciado sesion o no
        if (firebaseUser == null) {
            startActivity(new Intent(PantallaDeCarga.this, MainActivity.class));
            finish();
        } else {
            startActivity(new Intent(PantallaDeCarga.this, MenuPrincipal.class));
            Toast.makeText(this, "Iniciando sesion", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}