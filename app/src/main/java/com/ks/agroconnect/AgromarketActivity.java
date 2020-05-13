package com.ks.agroconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AgromarketActivity extends AppCompatActivity {
    WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agromarket);
        wb = findViewById(R.id.agro_market);
        wb.loadUrl("https://agmarknet.gov.in/");
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    @Override
    public void onBackPressed() {
        if (wb.canGoBack()) {
            wb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
