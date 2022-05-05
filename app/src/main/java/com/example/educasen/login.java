package com.example.educasen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    EditText CorreoLogin, PassLogin;
    Button Btn_Login;
    TextView UsuarioNuevoTXT;

    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;

    // Validar los datos
    String correo = "", password = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login");
        // Propiedades para retroceder y vuelve al mismo activity
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        // Inicializar las vistas
        CorreoLogin = findViewById(R.id.CorreoLogin);
        PassLogin = findViewById(R.id.PassLogin);
        Btn_Login = findViewById(R.id.Btn_Login);
        UsuarioNuevoTXT = findViewById(R.id.UsuarioNuevoTXT);

        // Inicializar firebase auth
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(login.this);
        progressDialog.setTitle("Espere por favor");
        // Para cuando al precionar afuera progressDialog de la barra de carga esta no se oculte
        progressDialog.setCanceledOnTouchOutside(false);

        // Evento del boton
        Btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Metodo validar datos
                ValidarDatos();
            }
        });

        UsuarioNuevoTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hipervinculo a la actividad de registro
                startActivity(new Intent(login.this, Registrar.class));
            }
        });
    }
    //Metodo validar datos
    private void ValidarDatos() {
        correo = CorreoLogin.getText().toString();
        password = PassLogin.getText().toString();

        if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this, "Correo invalido", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Ingrese contraseña", Toast.LENGTH_SHORT).show();
        } else {
            LoginDeUsuario();
        }
    }

    private void LoginDeUsuario() {
        progressDialog.setMessage("Iniciando sesion...");
        progressDialog.show();// Para que se pueda mostrar el progressDialog

        firebaseAuth.signInWithEmailAndPassword(correo, password)
                .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            progressDialog.dismiss(); //Para que se pueda ocultar
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            startActivity(new Intent(login.this, MenuPrincipal.class));
                            Toast.makeText(login.this, "Bienvenido(a): " + user.getEmail(), Toast.LENGTH_SHORT).show();
                            finish(); // Para que cuando ingresemos al menuprincipal y queramos retroceder no nos mandara a la act login

                        } else {
                            progressDialog.dismiss();// Para ocultarse
                            Toast.makeText(login.this, "Verifique si el correo y la contraseña son correctos", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(login.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();//Para si hay errores
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}