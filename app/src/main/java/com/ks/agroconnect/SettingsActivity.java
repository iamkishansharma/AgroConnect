package com.ks.agroconnect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    RelativeLayout settingLay;
    Switch dark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Switch dark = findViewById(R.id.dark_mode);

        settingLay= findViewById(R.id.setting_lay);
        dark = findViewById(R.id.dark_mode);
        dark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    settingLay.setBackgroundColor(getColor(R.color.darkMode));
                    Toast.makeText(SettingsActivity.this, "Enabled", Toast.LENGTH_SHORT).show();
                }else{
                    settingLay.setBackgroundColor(getColor(android.R.color.background_light));
                    Toast.makeText(SettingsActivity.this, "Disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView delete = findViewById(R.id.delete_acc);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("Deleting your Account")
                        .setMessage("Are you sure?")
                        .setView(R.layout.loading_dialog)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences settings = getSharedPreferences("accountRa", MODE_PRIVATE);
                                settings.edit().clear().apply();
                                startActivity(new Intent(SettingsActivity.this,MainActivity.class));
                                Toast.makeText(SettingsActivity.this, "Yes Clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.show();

            }
        });

    }
}
