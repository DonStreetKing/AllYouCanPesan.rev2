package com.example.allyoucanpesanrev2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Akun extends AppCompatActivity {
    Button logout;
    public static TextView NamaUser, EmailPengguna;
    String Nama, Email;
    SharedPreferences sharedPreferences;

    public static final String TAG_NAMA = "Nama";
    public static final String TAG_Email = "Email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        NamaUser = findViewById(R.id.NamaUser);
        EmailPengguna = findViewById(R.id.Email_Pengguna);
        logout = findViewById(R.id.Tombol_LogOut);

        sharedPreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);
        Nama = getIntent().getStringExtra(TAG_NAMA);
        Email = getIntent().getStringExtra(TAG_Email);

        NamaUser.setText(Nama);
        EmailPengguna.setText(Email);

        //Tombol Logout
        logout.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(Login.session_status, false);
            editor.putString(TAG_NAMA, null);
            editor.putString(TAG_Email, null);
            editor.commit();

            Intent intent = new Intent(Akun.this, Login.class);
            finish();
            startActivity(intent);
        });

        // Navigation Bar
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.PageAkun);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
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
        });
        // End Bottom Nav Bar
    }
}