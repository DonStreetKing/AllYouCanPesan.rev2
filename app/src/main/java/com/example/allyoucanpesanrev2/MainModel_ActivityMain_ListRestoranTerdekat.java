package com.example.allyoucanpesanrev2;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainModel_ActivityMain_ListRestoranTerdekat {

    ImageView GambarRestoran;
    TextView NamaRestoran;
    TextView TextToShow_JarakRestoranHome;
    TextView TextToShow_MejaTersediaHome;
    ImageButton TombolBukaMenu;
    MainModel_ActivityMain_ListRestoranTerdekat(View view)
    {
        GambarRestoran = view.findViewById(R.id.GambarRestoran);
        NamaRestoran = view.findViewById(R.id.NamaRestoran);
        TextToShow_JarakRestoranHome = view.findViewById(R.id.TextToShow_JarakRestoranHome);
        TextToShow_MejaTersediaHome = view.findViewById(R.id.TextToShow_MejaTersediaHome);
        TombolBukaMenu = view.findViewById(R.id.TombolBukaMenu);
    }
}