package com.example.allyoucanpesanrev2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.allyoucanpesanrev2.Model.MainModel_InRestauranMenu_ListMenuRestoran;
import com.example.allyoucanpesanrev2.R;

import java.util.List;

public class MainAdapter_InRestauranMenu_ListMenuRestoran extends ArrayAdapter<MainModel_InRestauranMenu_ListMenuRestoran> {
    private List<MainModel_InRestauranMenu_ListMenuRestoran> MenuRestoran;
    private Context context;

    public MainAdapter_InRestauranMenu_ListMenuRestoran(List<MainModel_InRestauranMenu_ListMenuRestoran> menuRestoran, Context context) {
        super(context, R.layout.isi_list_menurestoran_di_inrestauranmenu, menuRestoran);
        this.MenuRestoran = menuRestoran;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View listViewItem = inflater.inflate(R.layout.isi_list_menurestoran_di_inrestauranmenu, null, true);

        TextView TextToShowNamaMenu = listViewItem.findViewById(R.id.TextToShow_NamaMenu);
        TextView TextToShowHargaMenu = listViewItem.findViewById(R.id.TextToShow_HargaMenu);
        TextView TextToShowDeskripsiMenu = listViewItem.findViewById(R.id.TextToShow_DeskripsiMenu);

        MainModel_InRestauranMenu_ListMenuRestoran mainModel_inRestauranMenu_listMenuRestoran = MenuRestoran.get(position);

        TextToShowNamaMenu.setText(mainModel_inRestauranMenu_listMenuRestoran.getNama_Menu());
        TextToShowHargaMenu.setText(mainModel_inRestauranMenu_listMenuRestoran.getHarga_Menu());
        TextToShowDeskripsiMenu.setText(mainModel_inRestauranMenu_listMenuRestoran.getDeskripsi_Menu());
        return listViewItem;
    }
}