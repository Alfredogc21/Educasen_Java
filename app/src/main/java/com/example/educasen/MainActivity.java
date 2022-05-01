package com.example.educasen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo para los botones
    // Login
    public void Login (View verLogin) {
        Intent activityLogin= new Intent(this, login.class); //Para crear ciertas funciones de nuestro activity
        startActivity(activityLogin); // Metodo
    }

    public void Registrar (View verRegistrar) {
        Intent activityRegistrar = new Intent(this, Registrar.class);
        startActivity(activityRegistrar);
    }
}