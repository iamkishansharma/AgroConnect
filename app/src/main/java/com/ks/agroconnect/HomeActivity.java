package com.ks.agroconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    String[] day=   {"Sunday","Monday", "Tuesday","Wednesday","Thursday", "Friday","Saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView date = findViewById(R.id.date);
        Date dob = new Date();
        DateFormat dateFormat= new SimpleDateFormat("MMMM dd, yyyy");
        date.setText(day[dob.getDay()]+", "+dateFormat.format(dob));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout_menu:
                Toast.makeText(HomeActivity.this, "Logout", Toast.LENGTH_LONG).show();
                finish();
                return true;
            case R.id.about_menu:
                Toast.makeText(HomeActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting_menu:
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void assistance(View view) {
        startActivity(new Intent(HomeActivity.this,AssistanceActivity.class));
    }

    public void kisanKalyan(View view) {
        startActivity(new Intent(HomeActivity.this, KisankalyanActivity.class));
    }

    public void agromarket(View view) {
        startActivity(new Intent(HomeActivity.this,AgromarketActivity.class));
    }

    public void krisiUpdates(View view) {
        startActivity(new Intent(HomeActivity.this, KrishiupdatesActivity.class));
    }
}
