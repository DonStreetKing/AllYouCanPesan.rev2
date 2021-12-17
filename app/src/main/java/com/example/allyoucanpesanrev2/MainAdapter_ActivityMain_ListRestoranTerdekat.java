package com.example.allyoucanpesanrev2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class MainAdapter_ActivityMain_ListRestoranTerdekat extends ArrayAdapter<MainModel_ActivityMain_ListRestoranTerdekat> {
    private List<MainModel_ActivityMain_ListRestoranTerdekat> RestoranTerdekat;
    private Context context;

    public MainAdapter_ActivityMain_ListRestoranTerdekat(List<MainModel_ActivityMain_ListRestoranTerdekat> restoranTerdekat, Context context) {
        super(context, R.layout.isi_list_restoranterdekat_di_activitymain, restoranTerdekat);
    }
}