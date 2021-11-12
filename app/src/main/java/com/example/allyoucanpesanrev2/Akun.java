package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Akun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        //Tombol Logout
        Button logout = (Button) findViewById(R.id.Tombol_LogOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Akun.this, Login.class);
                startActivity(x);
            }
        });

        //Tombol Home
        ImageButton home = (ImageButton) findViewById(R.id.TombolHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Akun.this, MainActivity.class);
                startActivity(x);
            }
        });

        //Tombol Explore
        ImageButton explore = (ImageButton) findViewById(R.id.TombolExplore);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Akun.this, Explore.class);
                startActivity(x);
            }
        });

        //Tombol Transaksi
        ImageButton transaksi = (ImageButton) findViewById(R.id.TombolTransaksi);
        transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Akun.this, Transaksi.class);
                startActivity(x);
            }
        });
    }
}