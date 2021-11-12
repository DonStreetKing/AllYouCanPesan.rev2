package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Tombol login
        Button login = (Button) findViewById(R.id.Tombol_CreateAkun);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Login.this, MainActivity.class);
                startActivity(x);
            }
        });

        //Tombol Belum Punya akun
        TextView signup = (TextView) findViewById(R.id.Tombol_SudahPunyaAkun);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Login.this, SignUp.class);
                startActivity(x);
            }
        });
    }
}