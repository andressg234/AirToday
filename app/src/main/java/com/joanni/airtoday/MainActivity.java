package com.joanni.airtoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.joanni.airtoday.activities.LogIn;

public class MainActivity extends AppCompatActivity {

    TextView tvNombreApp;
    ImageView imgLogo;
    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombreApp = findViewById(R.id.tvNombreApp);
        imgLogo = findViewById(R.id.img_logo);

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.translate);
        tvNombreApp.startAnimation(rotate);
        imgLogo.startAnimation(rotate);

        openApp(true);
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity
                        .this, LogIn.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
