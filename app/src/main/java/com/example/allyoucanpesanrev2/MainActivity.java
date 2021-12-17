package com.example.allyoucanpesanrev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String URL_GetData_API = "http://192.168.1.2/getListResto.php";
    public MainModel_ActivityMain_ListRestoranTerdekat ListAPI;
    ListView ListRestoranTerdekat;
    private List<MainModel_ActivityMain_ListRestoranTerdekat> RestoranTerdekat;
    public String ID;

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

        // Start Tombol Explore
        ImageButton explore = (ImageButton) findViewById(R.id.TombolExplore);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this, Explore.class);
                startActivity(x);
            }
        });
        // End Tombol Explore

        // Start Tombol Transaksi
        ImageButton transaksi = (ImageButton) findViewById(R.id.TombolTransaksi);
        transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this, Transaksi.class);
                startActivity(x);
            }
        });
        //End Tombol Transaksi

        //Start Tombol Akun
        ImageButton akun = (ImageButton) findViewById(R.id.TombolAkun);
        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this, Akun.class);
                startActivity(x);
            }
        });
        //End Tombol Akun

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
                                jsonObject.getString("Nama_Restoran"),
                                jsonObject.getString("Jarak_Restoran"),
                                jsonObject.getString("Meja_Tersedia"));
                        RestoranTerdekat.add(ListAPI);
                    }
                    final MainAdapter_ActivityMain_ListRestoranTerdekat adapter = new MainAdapter_ActivityMain_ListRestoranTerdekat(RestoranTerdekat, getApplicationContext());
                    ListRestoranTerdekat.setAdapter(adapter);
                }
                catch (JSONException e) {
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
