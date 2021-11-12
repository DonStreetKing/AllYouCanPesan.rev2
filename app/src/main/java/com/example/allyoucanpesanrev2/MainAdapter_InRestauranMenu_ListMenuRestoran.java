package com.example.allyoucanpesanrev2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainAdapter_InRestauranMenu_ListMenuRestoran extends ArrayAdapter<String> {

    Context context;
    int[] GambarMenu;
    String[] NamaMenu;
    String[] TextToShow_DeskripsiMenu;
    String[] TextToShow_HargaMenu;

    public MainAdapter_InRestauranMenu_ListMenuRestoran(Context context, String[] NamaMenu, int[] GambarMenu, String[] TextToShow_DeskripsiMenu, String[] TextToShow_HargaMenu) {
        super(context, R.layout.isi_list_menurestoran_di_inrestauranmenu,R.id.NamaMenu, NamaMenu);
        this.context = context;
        this.GambarMenu = GambarMenu;
        this.NamaMenu = NamaMenu;
        this.TextToShow_DeskripsiMenu = TextToShow_DeskripsiMenu;
        this.TextToShow_HargaMenu = TextToShow_HargaMenu;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View SingleItem = convertView;
        MainModel_InRestauranMenu_ListMenuRestoran holder = null;

        if (SingleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            SingleItem = layoutInflater.inflate(R.layout.isi_list_menurestoran_di_inrestauranmenu, parent, false);
            holder = new MainModel_InRestauranMenu_ListMenuRestoran(SingleItem);
            SingleItem.setTag(holder);
        }

        else {
            holder = (MainModel_InRestauranMenu_ListMenuRestoran) SingleItem.getTag();
        }
        holder.GambarMenu.setImageResource(GambarMenu[position]);
        holder.NamaMenu.setText(NamaMenu[position]);
        holder.TextToShow_DeskripsiMenu.setText(TextToShow_DeskripsiMenu[position]);
        holder.TextToShow_HargaMenu.setText(TextToShow_HargaMenu[position]);
        SingleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Anda tekan: "+NamaMenu[position], Toast.LENGTH_SHORT).show();
            }
        });
        return SingleItem;
    }
}