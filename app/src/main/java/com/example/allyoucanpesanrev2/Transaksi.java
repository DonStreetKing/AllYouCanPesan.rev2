package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Transaksi extends AppCompatActivity {

    // Ini Array di ListView RestoranTerdekat
    ListView ShowListTransaksi;
    String[] NamaRestoran = {"Rainbow Six Siege", "Ghost Recon Wildland", "Tomb Raider"};
    String[] TextToShow_TanggalPembelian = {"https://store.steampowered.com/app/359550", "https://store.steampowered.com/app/359550", "https://store.steampowered.com/app/359550"};
    String[] TextToShow_TotalBiaya = {"5 Meja", "10 Meja", "6 Meja"};

    int[] GambarRestoran = {R.drawable.logo_kfc, R.drawable.logo_burgerking, R.drawable.logo_mcdonald};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        ShowListTransaksi = findViewById(R.id.ShowListTransaksi);
        MainAdapter_Transaksi_ListTransaksi Adapter_Transaksi_ListTransaksi = new MainAdapter_Transaksi_ListTransaksi(this, NamaRestoran, GambarRestoran, TextToShow_TanggalPembelian, TextToShow_TotalBiaya);
        ShowListTransaksi.setAdapter(Adapter_Transaksi_ListTransaksi);

    }
}