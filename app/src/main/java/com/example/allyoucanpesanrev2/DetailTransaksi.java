package com.example.allyoucanpesanrev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailTransaksi extends AppCompatActivity {

    TextView IDTransaksi, MetodeTransaksi, TotalPayment, TanggalTransaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaksi);

        IDTransaksi = findViewById(R.id.ID_Transaksi);
        MetodeTransaksi = findViewById(R.id.MetodePembayaran);
        TotalPayment = findViewById(R.id.TotalPayment);
        TanggalTransaksi = findViewById(R.id.TanggalTransaksi);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String ID_Transaksi = data.getString("ID_Transaksi");
        String Metode_Pembayaran = data.getString("Metode_Pembayaran");
        String Total_Payment = data.getString("Jumlah_Transaksi");
        String Tanggal_Transaksi = data.getString("Tanggal_Transaksi");

        IDTransaksi.setText("ID Transaksi: " + ID_Transaksi);
        MetodeTransaksi.setText("Metode Pembayaran: " + Metode_Pembayaran);
        TotalPayment.setText("Jumlah Pembayaran: " + Total_Payment);
        TanggalTransaksi.setText("Tanggal Transaksi: " + Tanggal_Transaksi);
    }
}