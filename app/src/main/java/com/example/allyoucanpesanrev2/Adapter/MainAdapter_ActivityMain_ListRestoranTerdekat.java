package com.example.allyoucanpesanrev2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.allyoucanpesanrev2.Model.MainModel_ActivityMain_ListRestoranTerdekat;
import com.example.allyoucanpesanrev2.R;

import java.util.List;

public class MainAdapter_ActivityMain_ListRestoranTerdekat extends ArrayAdapter<MainModel_ActivityMain_ListRestoranTerdekat> {
    private List<MainModel_ActivityMain_ListRestoranTerdekat> RestoranTerdekat;
    private Context context;

    public MainAdapter_ActivityMain_ListRestoranTerdekat(List<MainModel_ActivityMain_ListRestoranTerdekat> restoranTerdekat, Context context) {
        super(context, R.layout.isi_list_restoranterdekat_di_activitymain, restoranTerdekat);
        this.RestoranTerdekat = restoranTerdekat;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View listViewItem = inflater.inflate(R.layout.isi_list_restoranterdekat_di_activitymain, null, true);

        TextView TextToShowNamaRestoran = listViewItem.findViewById(R.id.TextToShow_NamaRestoran);
        TextView TextToShowJarakRestoran = listViewItem.findViewById(R.id.TextToShow_JarakRestoranHome);
        TextView TextToShowMejaTersedia = listViewItem.findViewById(R.id.TextToShow_MejaTersediaHome);
        TextView TextToShowJamBuka = listViewItem.findViewById(R.id.TextToShow_JamBuka);
        TextView TextToShowJamTutup = listViewItem.findViewById(R.id.TextToShow_JamTutup);
//        ImageView Gambar_Restoran = listViewItem.findViewById(R.id.GambarRestoran);

        MainModel_ActivityMain_ListRestoranTerdekat mainModel_activityMain_listRestoranTerdekat = RestoranTerdekat.get(position);

        TextToShowNamaRestoran.setText(mainModel_activityMain_listRestoranTerdekat.getNama_Restoran());
        TextToShowJarakRestoran.setText(mainModel_activityMain_listRestoranTerdekat.getJarak_Restoran() + " KM dari sini");
        TextToShowMejaTersedia.setText(mainModel_activityMain_listRestoranTerdekat.getMeja_Tersedia() + " Meja Tersedia");
        TextToShowJamBuka.setText(mainModel_activityMain_listRestoranTerdekat.getJam_Buka());
        TextToShowJamTutup.setText(mainModel_activityMain_listRestoranTerdekat.getJam_Tutup());

//        Glide.with(context).load(mainModel_activityMain_listRestoranTerdekat.getGambar_Restoran()).into(Gambar_Restoran);

        return listViewItem;
    }
}