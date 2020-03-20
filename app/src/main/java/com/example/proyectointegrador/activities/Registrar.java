package com.example.proyectointegrador.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.proyectointegrador.R;
import com.example.proyectointegrador.firebase.DatosRegistro;
import com.example.proyectointegrador.firebase.RegistroAdapter;

import java.util.ArrayList;
import java.util.Date;

public class Registrar extends AppCompatActivity {

    EditText etEmail;
    EditText etContraseña;
    DatabaseReference dbRegistro;
    ChildEventListener cel;
    RegistroAdapter ra;
    private String empresa;
    ArrayList<DatosRegistro> listaRegistros;

    FirebaseAuth fa;
    FirebaseUser fu;
    FirebaseAuth.AuthStateListener asl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        listaRegistros = new ArrayList<DatosRegistro>();
        empresa = "AirToday";
        etEmail = findViewById(R.id.etEmail);
        etContraseña = findViewById(R.id.etContraseña);
        dbRegistro = FirebaseDatabase.getInstance().getReference().child("Registro");
        fa = FirebaseAuth.getInstance();
        fu = fa.getCurrentUser();
        ra = new RegistroAdapter(listaRegistros);

    }

    public void registrar(View view) {
        String email = etEmail.getText().toString().trim();
        String contraseña = etContraseña.getText().toString().trim();

        if (contraseña.length() < 6){
            Toast.makeText(Registrar.this, "La contraseña debe tener más de 6 caracteres", Toast.LENGTH_SHORT).show();
        } else if (!email.isEmpty() && !contraseña.isEmpty()) {

            fa.createUserWithEmailAndPassword(email, contraseña)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                fu = fa.getCurrentUser();
                                limpiar();

                                Intent intent = new Intent(Registrar
                                        .this, Confirmacion.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Registrar.this, "El correo que ha introducido ya existe, pruebe con otro", Toast.LENGTH_SHORT).show();
                            } } });

        } else {
            Toast.makeText(getBaseContext(), "Se ha producido un error en el registro", Toast.LENGTH_LONG).show();
        }
    }

    public void limpiar(){
        etEmail.setText("");
        etContraseña.setText("");
    }
}
