package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MenuRestoran extends AppCompatActivity {

    //Bagian 1 "// Ini Array di ListView Menu Restoran"
    ListView ListMenuRestoran;
    String[] NamaMenu = {"Rainbow Six Siege", "Ghost Recon Wildland", "Tomb Raider"};
    String[] TextToShow_DeskripsiMenu = {"https://store.steampowered.com/app/359550", "https://store.steampowered.com/app/359550", "https://store.steampowered.com/app/359550"};
    String[] TextToShow_HargaMenu = {"5 Meja", "10 Meja", "6 Meja"};

    int[] GambarMenu = {R.drawable.logo_kfc, R.drawable.logo_burgerking, R.drawable.logo_mcdonald};
    //END Bagian 1 "// Ini Array di ListView Menu Restoran"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restoran);

        //Bagian 2 "// Ini Array di ListView Menu Restoran"
        ListMenuRestoran = findViewById(R.id.ShowList_RestoranTerdekat);
        MainAdapter_InRestauranMenu_ListMenuRestoran Adapter_InRestauranMenu_ListMenuRestoran = new MainAdapter_InRestauranMenu_ListMenuRestoran(this, NamaMenu, GambarMenu, TextToShow_DeskripsiMenu, TextToShow_HargaMenu);
        ListMenuRestoran.setAdapter(Adapter_InRestauranMenu_ListMenuRestoran);
        //END Bagian 2 "// Ini Array di ListView Menu Restoran"
    }
}