package com.ks.agroconnect;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass, pass2;
    private TextView signin_txt;
    Button btnReg;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.regi_email);
        pass = findViewById(R.id.regi_password);
        pass2 = findViewById(R.id.regi_re_password);
        signin_txt = findViewById(R.id.signIn_text);
        btnReg = findViewById(R.id.signUP);

        mSharedPreferences = getSharedPreferences("accountRa", MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        //Progress Dialog Created
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog);
        final AlertDialog dialog = builder.create();

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = pass.getText().toString().trim();
                String mPass2 = pass2.getText().toString().trim();
                if (TextUtils.isEmpty(mEmail)){
                    email.setError("Required Field...");
                    return;
                }
                if(TextUtils.isEmpty(mPass)){
                    pass.setError("Required Field...");
                    return;
                }
                if(TextUtils.isEmpty(mPass2)){
                    pass2.setError("Required Field...");
                    return;
                }
                if(mPass.equals(mPass2)){

                    dialog.show();//Progress Dialog called


                    editor.putString("email", mEmail);
                    editor.putString("password",mPass);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "Registered\nNow Login !", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    finish();
                }
            }
        });

        signin_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
