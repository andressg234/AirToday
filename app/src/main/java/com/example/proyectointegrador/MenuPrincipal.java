package com.example.proyectointegrador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.proyectointegrador.R;

public class MenuPrincipal extends AppCompatActivity {

    MenuItem itmMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itmMapa = findViewById(R.id.itmIconMapa);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itmIconAire) {



        } else if(item.getItemId() == R.id.itmIconMapa) {


            Intent i = new Intent(this, Mapa.class);
            startActivity(i);


        } else if(item.getItemId() == R.id.itmIconAire) {



        } else if(item.getItemId() == R.id.itmIconCalendario) {



        } else if(item.getItemId() == R.id.itmIconChat) {

            Intent i = new Intent(this, Chat.class);
            startActivity(i);

        } else if(item.getItemId() == R.id.itmIconBuscar) {



        }/* else if(item.getItemId() == R.id.itmIconPerfil) {

            Intent i = new Intent(this, Perfil.class);
            startActivity(i);

        }*/


        return super.onOptionsItemSelected(item);
    }
}

