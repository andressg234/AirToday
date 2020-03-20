package com.example.proyectointegrador.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.proyectointegrador.R;

public class ChatBotActivity extends AppCompatActivity {

    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        myWebView = (WebView) findViewById(R.id.wv1);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://console.dialogflow.com/api-client/demo/embedded/8bdc90d9-220d-4103-a629-4447040aa20a");

    }

}
