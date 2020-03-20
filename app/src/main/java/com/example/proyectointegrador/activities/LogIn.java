package com.example.proyectointegrador.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectointegrador.MenuPrincipal;
import com.example.proyectointegrador.R;
import com.example.proyectointegrador.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;

    private FirebaseAuth fa;
    private FirebaseUser fu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        fa = FirebaseAuth.getInstance();
    }

    public void Entrar(View view) {
        String email = etEmail.getText().toString().trim();
        String passw = etPassword.getText().toString().trim();
        String msj = validarDatos();

        if (msj != null){
            Toast.makeText(this, msj , Toast.LENGTH_LONG).show();
        }else {
            fa.signInWithEmailAndPassword(email, passw)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                fu = fa.getCurrentUser();

                                etEmail.setText("");
                                etPassword.setText("");

                                Intent i = new Intent(LogIn.this, MenuPrincipal.class);
                                startActivity(i);

                            } else {
                                Toast.makeText(LogIn.this, 	"Los credenciales no coninciden",Toast.LENGTH_SHORT).show();
                            } } });

        }

    }

    public void registrarse (View v) {
        Intent i = new Intent(this, Registrar.class);
        startActivity(i);
    }

    private String validarDatos(){
        String email = etEmail.getText().toString().trim();
        String passw = etPassword.getText().toString().trim();

        email = etEmail.getText().toString().trim();
        passw = etPassword.getText().toString().trim();
        String msj = null;

        if (email.isEmpty() || passw.isEmpty()){
            msj = "Debes introducir el email y la contraseña!!";
        }
        return msj;
    }
}
