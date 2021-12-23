package com.example.allyoucanpesanrev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Explore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);


        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.PageExplore);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.PageHome:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        return true;
                    case R.id.PageExplore:
//                        startActivity(new Intent(getApplicationContext(), Explore.class));
                        return true;
                    case R.id.PageTransaksi:
                        startActivity(new Intent(getApplicationContext(), Transaksi.class));
                        return true;
                    case R.id.PageAkun:
                        startActivity(new Intent(getApplicationContext(), Akun.class));
                        return true;
                }
                return false;
            }
        });
    }
}