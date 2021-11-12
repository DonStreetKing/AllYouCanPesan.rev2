package com.example.allyoucanpesanrev2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainAdapter_ActivityMain_ListRestoranTerdekat extends ArrayAdapter<String> {

    Context context;
    int[] GambarRestoran;
    String[] NamaRestoran;
    String[] JarakRestoran;
    String[] MejaTersedia;

    public MainAdapter_ActivityMain_ListRestoranTerdekat(Context context, String[] NamaRestoran, int[] GambarRestoran, String[] JarakRestoran, String[] MejaTersedia) {
        super(context, R.layout.isi_list_restoranterdekat_di_activitymain, R.id.NamaRestoran, NamaRestoran);
        this.context = context;
        this.GambarRestoran = GambarRestoran;
        this.NamaRestoran = NamaRestoran;
        this.JarakRestoran = JarakRestoran;
        this.MejaTersedia = MejaTersedia;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View SingleItem = convertView;
        MainModel_ActivityMain_ListRestoranTerdekat holder = null;

        if (SingleItem == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            SingleItem = layoutInflater.inflate(R.layout.isi_list_restoranterdekat_di_activitymain, parent, false);
            holder = new MainModel_ActivityMain_ListRestoranTerdekat(SingleItem);
            SingleItem.setTag(holder);
        } else {
            holder = (MainModel_ActivityMain_ListRestoranTerdekat) SingleItem.getTag();
        }
        holder.GambarRestoran.setImageResource(GambarRestoran[position]);
        holder.NamaRestoran.setText(NamaRestoran[position]);
        holder.TextToShow_JarakRestoranHome.setText(JarakRestoran[position]);
        holder.TextToShow_MejaTersediaHome.setText(MejaTersedia[position]);
        SingleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Anda tekan: " + NamaRestoran[position], Toast.LENGTH_SHORT).show();
            }
        });
        return SingleItem;

    }
}