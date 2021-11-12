package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Bagian 1 Ini Array di ListView Restoran Terdekat
    ListView ListRestoranTerdekat;
    String[] NamaRestoran = {"Rainbow Six Siege", "Ghost Recon Wildland", "Tomb Raider"};
    String[] TextToShow_JarakRestoranHome = {"https://store.steampowered.com/app/359550", "https://store.steampowered.com/app/359550", "https://store.steampowered.com/app/359550"};
    String[] TextToShow_MejaTersediaHome = {"5 Meja", "10 Meja", "6 Meja"};
    //END Bagian 1 "// Ini Array di ListView Restoran Terdekat"

    int[] GambarRestoran = {R.drawable.logo_kfc, R.drawable.logo_burgerking, R.drawable.logo_mcdonald};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bagian 2 "// Ini Array di ListView Restoran Terdekat"
        ListRestoranTerdekat = findViewById(R.id.ShowList_RestoranTerdekat);
        MainAdapter_ActivityMain_ListRestoranTerdekat adapterUntukListRestoranTerdekat_activitymain = new MainAdapter_ActivityMain_ListRestoranTerdekat(this, NamaRestoran, GambarRestoran, TextToShow_JarakRestoranHome, TextToShow_MejaTersediaHome);
        ListRestoranTerdekat.setAdapter(adapterUntukListRestoranTerdekat_activitymain);
        //END Bagian 2 "// Ini Array di ListView Restoran Terdekat"


        //======================= Horizontal View =================================\\

        // Start Tombol RestoranNoTutup
        ImageButton duaempatjam = (ImageButton) findViewById(R.id.TombolRestoranNoTutup);
        duaempatjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this, RestoranNoTutup.class);
                startActivity(x);
            }
        });
        //End Tombol RestoranNoTutup

        // ======================== Bottom Navigasi ======================================= \\\

        // Start Tombol Explore
        ImageButton explore = (ImageButton) findViewById(R.id.TombolExplore);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this, Explore.class);
                startActivity(x);
            }
        });
        // End Tombol Explore

        // Start Tombol Transaksi
        ImageButton transaksi = (ImageButton) findViewById(R.id.TombolTransaksi);
        transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this, Transaksi.class);
                startActivity(x);
            }
        });
        //End Tombol Transaksi

        //Start Tombol Akun
        ImageButton akun = (ImageButton) findViewById(R.id.TombolAkun);
        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this, Akun.class);
                startActivity(x);
            }
        });
        //End Tombol Akun
    }
}