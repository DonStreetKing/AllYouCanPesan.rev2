package com.example.allyoucanpesanrev2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.allyoucanpesanrev2.Adapter.MainAdapter_InRestauranMenu_ListMenuRestoran;
import com.example.allyoucanpesanrev2.AdditionalNeededClass.Server;
import com.example.allyoucanpesanrev2.Model.MainModel_InRestauranMenu_ListMenuRestoran;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MenuRestoran extends AppCompatActivity {
    public static final String URL_Menu_Restoran = Server.URL + "Get_ListMenuRestoran.php";
    public MainModel_InRestauranMenu_ListMenuRestoran MenuRestoranAPI;
    ListView ListMenuRestoran;
    private List<MainModel_InRestauranMenu_ListMenuRestoran> MenuRestoran;
    TextView TextToShow_inBanner_NamaRestoran, TextToShow_inBanner_JarakRestoran, TextToShow_inBanner_MejaTersedia, TextToShow_inBanner_WaktuOperasional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restoran);

        TextToShow_inBanner_NamaRestoran = findViewById(R.id.TextToShow_inBanner_NamaRestoran);
        TextToShow_inBanner_JarakRestoran = findViewById(R.id.TextToShow_inBanner_JarakRestoran);
        TextToShow_inBanner_MejaTersedia = findViewById(R.id.TextToShow_inBanner_MejaTersedia);
        TextToShow_inBanner_WaktuOperasional = findViewById(R.id.TextToShow_inBanner_WaktuOperasional);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String NamaRestoran = data.getString("Nama_Restoran");
        String JarakRestoran = data.getString("Jarak_Restoran");
        String MejaTersedia = data.getString("Meja_Tersedia");

        String JamBuka = data.getString("Jam_Buka");
        String JamTutup = data.getString("Jam_Tutup");

        TextToShow_inBanner_NamaRestoran.setText(NamaRestoran);
        TextToShow_inBanner_JarakRestoran.setText(JarakRestoran + " KM dari sini");
        TextToShow_inBanner_MejaTersedia.setText(MejaTersedia + " Meja Tersedia");
        TextToShow_inBanner_WaktuOperasional.setText(JamBuka + " - " + JamTutup);


        // Databases untuk Menu
        ListMenuRestoran = findViewById(R.id.List_MenuRestoran);
        MenuRestoran = new ArrayList<>();

        ListMenuRestoran.setOnItemClickListener((parent, view, position, id) -> {
            MainAdapter_InRestauranMenu_ListMenuRestoran adapter = new MainAdapter_InRestauranMenu_ListMenuRestoran(MenuRestoran, getApplicationContext());

            ListMenuRestoran.setAdapter(adapter);
            MainModel_InRestauranMenu_ListMenuRestoran posisi = adapter.getItem(position);
            Bundle data1 = new Bundle();
            data1.putString("Nama_Menu", posisi.getNama_Menu());
            data1.putString("Harga_Menu", posisi.getHarga_Menu());
            data1.putString("Deskripsi_Menu", posisi.getDeskripsi_Menu());


        });
        loaditem();

        // Total belanja dari item
        


        //Tombol Checkout
        Button checkout = findViewById(R.id.Tombol_Checkout);
        checkout.setOnClickListener(view -> {

            Intent x = new Intent(MenuRestoran.this, Checkout.class);
            startActivity(x);
        });
        // End Tombol Checkout
    }
    private void loaditem() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_Menu_Restoran, null, response -> {
            try {
                Log.d("JsonArray", response.toString());
                for (int i = 0; i < response.length(); i++) {
                    JSONObject jsonObject = response.getJSONObject(i);

                    MenuRestoranAPI = new MainModel_InRestauranMenu_ListMenuRestoran(
                            jsonObject.getString("Nama_Menu"),
                            jsonObject.getString("Harga_Menu"),
                            jsonObject.getString("Deskripsi_Menu"));
                    MenuRestoran.add(MenuRestoranAPI);
                }
                final MainAdapter_InRestauranMenu_ListMenuRestoran adapter = new MainAdapter_InRestauranMenu_ListMenuRestoran(MenuRestoran, getApplicationContext());
                ListMenuRestoran.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        },
                error -> Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show());
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

}