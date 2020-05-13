package com.ks.agroconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AssistanceActivity extends AppCompatActivity {

    Button viCall;
    Button voCall;
    Button chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viCall = findViewById(R.id.videoCall);
        viCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AssistanceActivity.this, getResources().getText(R.string.call_text), Toast.LENGTH_SHORT).show();
            }
        });
        voCall = findViewById(R.id.phoneCall);
        voCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AssistanceActivity.this, getResources().getText(R.string.vcall_text), Toast.LENGTH_SHORT).show();
            }
        });
        chat = findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AssistanceActivity.this, getResources().getText(R.string.chat_text), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
