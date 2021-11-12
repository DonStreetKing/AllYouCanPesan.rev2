package com.example.allyoucanpesanrev2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MainModel_Transaksi_ListTransaksi {

    ImageView GambarRestoran;
    TextView NamaRestoran;
    TextView TextToShow_TanggalPembelian;
    TextView TextToShow_TotalBiaya;
    MainModel_Transaksi_ListTransaksi(@NonNull View view)
    {
        GambarRestoran = view.findViewById(R.id.GambarRestoran);
        NamaRestoran = view.findViewById(R.id.NamaRestoran);
        TextToShow_TanggalPembelian = view.findViewById(R.id.TextToShow_TanggalPembelian);
        TextToShow_TotalBiaya = view.findViewById(R.id.TextToShow_TotalBiaya);
    }
}