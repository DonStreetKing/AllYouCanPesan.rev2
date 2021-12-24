package com.example.allyoucanpesanrev2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.allyoucanpesanrev2.Adapter.MainAdapter_ActivityMain_ListRestoranTerdekat;
import com.example.allyoucanpesanrev2.Model.MainModel_ActivityMain_ListRestoranTerdekat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String URL_GetData_API = "http://donstreetking.duckdns.org:8082/API/AllYouCanPesan/Get_ListRestoran.php";
    public MainModel_ActivityMain_ListRestoranTerdekat ListAPI;
    ListView ListRestoranTerdekat;
    private List<MainModel_ActivityMain_ListRestoranTerdekat> RestoranTerdekat;
    public String ID;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //======================= Horizontal View =================================\\

        // Start Tombol RestoranNoTutup
        ImageButton duaempatjam = (ImageButton) findViewById(R.id.TombolRestoranNoTutup);
        duaempatjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this, RestoranNoTutup.class);
                startActivity(x);
            }
        });
        //End Tombol RestoranNoTutup

        // ======================== Bottom Navigasi ======================================= \\\
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.PageHome);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.PageHome:
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        return true;
                    case R.id.PageExplore:
                        startActivity(new Intent(getApplicationContext(), Explore.class));
                        return true;
                    case R.id.PageTransaksi:
                        startActivity(new Intent(getApplicationContext(), Transaksi.class));
                        return true;
                    case R.id.PageAkun:
                        startActivity(new Intent(getApplicationContext(), Akun.class));
                        return true;
                }
                return false;
            }
        });

        // Database untuk List Item nya
        ListRestoranTerdekat = findViewById(R.id.ShowList_RestoranTerdekat);
        RestoranTerdekat = new ArrayList<>();

        ListRestoranTerdekat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MenuRestoran.class);
                MainAdapter_ActivityMain_ListRestoranTerdekat adapter = new MainAdapter_ActivityMain_ListRestoranTerdekat(RestoranTerdekat, getApplicationContext());

                ListRestoranTerdekat.setAdapter(adapter);
                MainModel_ActivityMain_ListRestoranTerdekat posisi = adapter.getItem(position);
                Bundle data = new Bundle();
                data.putString("Nama_Restoran", posisi.getNama_Restoran());
                data.putString("Jarak_Restoran", posisi.getJarak_Restoran());
                data.putString("Meja_Tersedia", posisi.getMeja_Tersedia());
                data.putString("Jam_Buka", posisi.getJam_Buka());
                data.putString("Jam_Tutup", posisi.getJam_Tutup());
                intent.putExtras(data);
                startActivity(intent);

            }
        });
        loaditem();
    }

    private void loaditem() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_GetData_API, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Log.d("JsonArray", response.toString());
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        ListAPI = new MainModel_ActivityMain_ListRestoranTerdekat(
//                                jsonObject.getString("Gambar_Restoran"),
                                jsonObject.getString("Nama_Restoran"),
                                jsonObject.getString("Jarak_Restoran"),
                                jsonObject.getString("Meja_Tersedia"),
                                jsonObject.getString("Jam_Buka"),
                                jsonObject.getString("Jam_Tutup"));
                        RestoranTerdekat.add(ListAPI);
                    }
                    final MainAdapter_ActivityMain_ListRestoranTerdekat adapter = new MainAdapter_ActivityMain_ListRestoranTerdekat(RestoranTerdekat, getApplicationContext());
                    ListRestoranTerdekat.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
