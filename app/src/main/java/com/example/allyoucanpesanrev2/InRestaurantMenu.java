package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class InRestaurantMenu extends AppCompatActivity {

    // Ini Array di ListView Restoran Terdekat
    ListView ListMenuRestoran;
    String[] NamaMenu = {"Rainbow Six Siege", "Ghost Recon Wildland", "Tomb Raider"};
    String[] TextToShow_DeskripsiMenu = {"https://store.steampowered.com/app/359550", "https://store.steampowered.com/app/359550", "https://store.steampowered.com/app/359550"};
    String[] TextToShow_HargaMenu = {"5 Meja", "10 Meja", "6 Meja"};

    int[] GambarMenu = {R.drawable.logo_kfc, R.drawable.logo_burgerking, R.drawable.logo_mcdonald};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_restaurant_menu);

        ListMenuRestoran = findViewById(R.id.ListMenuRestoran);
        MainAdapter_InRestauranMenu_ListMenuRestoran Adapter_InRestauranMenu_ListMenuRestaurant = new MainAdapter_InRestauranMenu_ListMenuRestoran(this, NamaMenu, GambarMenu, TextToShow_DeskripsiMenu, TextToShow_HargaMenu);
        ListMenuRestoran.setAdapter(Adapter_InRestauranMenu_ListMenuRestaurant);

        // Tombol ke activity Checkout
        Button tocheckout = (Button) findViewById(R.id.Tombol_Checkout);
        tocheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(InRestaurantMenu.this, Checkout.class);
                startActivity(x);
            }
        });
    }

}