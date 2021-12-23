package com.example.allyoucanpesanrev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Akun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);
        // Navigation Bar
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.PageAkun);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.PageHome:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        return true;
                    case R.id.PageExplore:
                        startActivity(new Intent(getApplicationContext(), Explore.class));
                        return true;
                    case R.id.PageTransaksi:
                        startActivity(new Intent(getApplicationContext(), Transaksi.class));
                        return true;
                    case R.id.PageAkun:
//                        startActivity(new Intent(getApplicationContext(), Akun.class));
                        return true;
                }
                return false;
            }
        });
        // End Bottom Nav Bar

        //Tombol Logout
        Button logout = (Button) findViewById(R.id.Tombol_LogOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Akun.this, Login.class);
                startActivity(x);
            }
        });
    }
}