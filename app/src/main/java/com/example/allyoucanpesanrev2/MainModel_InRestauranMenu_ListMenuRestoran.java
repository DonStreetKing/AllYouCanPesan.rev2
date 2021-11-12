package com.example.allyoucanpesanrev2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MainModel_InRestauranMenu_ListMenuRestoran {

    ImageView GambarMenu;
    TextView NamaMenu;
    TextView TextToShow_DeskripsiMenu;
    TextView TextToShow_HargaMenu;
    MainModel_InRestauranMenu_ListMenuRestoran(@NonNull View view)
    {
        GambarMenu = view.findViewById(R.id.GambarMenu);
        NamaMenu = view.findViewById(R.id.NamaMenu);
        TextToShow_DeskripsiMenu = view.findViewById(R.id.TextToShow_DeskripsiMenu);
        TextToShow_HargaMenu = view.findViewById(R.id.TextToShow_HargaMenu);
    }
}