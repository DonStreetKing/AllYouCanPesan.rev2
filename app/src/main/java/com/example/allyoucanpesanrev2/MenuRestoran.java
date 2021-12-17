package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuRestoran extends AppCompatActivity {
    public static final String URL_Menu_Restoran = "http://192.168.1.2";
    public MainModel_InRestauranMenu_ListMenuRestoran MenuRestoranAPI;
    ListView ListMenuRestoran;
    private List<MainModel_InRestauranMenu_ListMenuRestoran> MenuRestoran;
    public String SS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restoran);

        //Tombol Checkout



        // Databases untuk Menu
        ListMenuRestoran = findViewById(R.id.List_MenuRestoran);
        MenuRestoran = new ArrayList<>();

        ListMenuRestoran.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(com.example.allyoucanpesanrev2.MenuRestoran.this, Checkout.class);
                MainAdapter_InRestauranMenu_ListMenuRestoran adapter = new MainAdapter_InRestauranMenu_ListMenuRestoran(MenuRestoran, getApplicationContext());

                ListMenuRestoran.setAdapter(adapter);
                MainModel_InRestauranMenu_ListMenuRestoran posisi = adapter.getItem(position);
                Bundle data = new Bundle();
                data.putString("Nama_Menu", posisi.getNama_Menu());
                data.putString("Harga_Menu", posisi.getHarga_Menu());
                data.putString("Deskripsi_Menu", posisi.getDeskripsi_Menu());
                intent.putExtras(data);
                startActivity(intent);
            }
        });

    }
}