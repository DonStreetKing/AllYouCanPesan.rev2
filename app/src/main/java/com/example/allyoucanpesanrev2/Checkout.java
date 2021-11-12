package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Tombol Continue
        Button lanjutkebayar = (Button) findViewById(R.id.TombolContinue1);
        lanjutkebayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(Checkout.this, MetodePembayaran.class);
                startActivity(x);
            }
        });
    }
}