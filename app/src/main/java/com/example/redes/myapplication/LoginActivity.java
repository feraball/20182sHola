package com.example.redes.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import android.view.*;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView usernameTxt = findViewById(R.id.textViewShowUsername);
        final TextView passwordTxt = findViewById(R.id.textViewShowPassword);
        final TextView codeTxt = findViewById(R.id.textViewShowCode);

        Intent i = getIntent();

        String valueUsername = i.getStringExtra("usernameData");
        String valuePassword= i.getStringExtra("passwordData");
        String valuecode= i.getStringExtra("codeData");

        usernameTxt.setText(valueUsername);
        passwordTxt.setText(valuePassword);
        codeTxt.setText(valuecode);

    }
}
