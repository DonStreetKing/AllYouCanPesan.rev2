package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MetodePembayaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metode_pembayaran);

        //Tombol PayNow
        Button bayarsekarang = (Button) findViewById(R.id.TombolPayNow);
        bayarsekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MetodePembayaran.this, ConfirmPayment_QRCode.class);
                startActivity(x);
            }
        });
    }
}