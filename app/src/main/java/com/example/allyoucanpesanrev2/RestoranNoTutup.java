package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RestoranNoTutup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restoran_no_tutup);

        //Tombol Menu
        ImageButton bukamenu = (ImageButton) findViewById(R.id.TombolBukaMenuResto);
        bukamenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(RestoranNoTutup.this, InRestaurantMenu.class);
                startActivity(x);
            }
        });
    }
}