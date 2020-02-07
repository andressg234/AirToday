package com.joanni.airtoday.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.joanni.airtoday.R;

public class LogIn extends AppCompatActivity {

    EditText etUsuario;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
    }
}
