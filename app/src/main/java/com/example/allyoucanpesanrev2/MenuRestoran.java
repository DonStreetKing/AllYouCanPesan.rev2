package com.example.allyoucanpesanrev2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                Intent intent = new Intent(MenuRestoran.this, Checkout.class);
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
        loaditem();
    }
    private void loaditem() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_Menu_Restoran, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
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