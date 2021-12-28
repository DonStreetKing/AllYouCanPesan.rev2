package com.example.allyoucanpesanrev2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.allyoucanpesanrev2.Adapter.MainAdapter_ActivityMain_ListRestoranTerdekat;
import com.example.allyoucanpesanrev2.Adapter.SliderAdapter;
import com.example.allyoucanpesanrev2.AdditionalNeededClass.Server;
import com.example.allyoucanpesanrev2.AdditionalNeededClass.SliderData;
import com.example.allyoucanpesanrev2.Model.MainModel_ActivityMain_ListRestoranTerdekat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String URL_GetData_API = Server.URL + "Get_ListRestoran.php";
    public MainModel_ActivityMain_ListRestoranTerdekat ListAPI;
    ListView ListRestoranTerdekat;
    private List<MainModel_ActivityMain_ListRestoranTerdekat> RestoranTerdekat;
    public String ID;
    private MenuItem item;

    String URLPromo = Server.URLPromo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bagian Promo// == https://www.geeksforgeeks.org/auto-image-slider-in-android-with-example/ ==
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        SliderView sliderView = findViewById(R.id.slider);

        sliderDataArrayList.add(new SliderData(URLPromo + "promo1.jpg"));
        sliderDataArrayList.add(new SliderData(URLPromo + "promo2.jpg"));
        sliderDataArrayList.add(new SliderData(URLPromo + "promo3.jpg"));

        SliderAdapter adapter1 = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter1);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        // End Bagian Promo

        //======================= Horizontal View =================================\\

        // Start Tombol RestoranNoTutup
        ImageButton duaempatjam = findViewById(R.id.TombolRestoranNoTutup);
        duaempatjam.setOnClickListener(view -> {

            Intent x = new Intent(MainActivity.this, RestoranNoTutup.class);
            startActivity(x);
        });
        //End Tombol RestoranNoTutup

        // ======================== Bottom Navigasi ======================================= \\\
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.PageHome);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
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
        });

        // Database untuk List Item nya
        ListRestoranTerdekat = findViewById(R.id.ShowList_RestoranTerdekat);
        RestoranTerdekat = new ArrayList<>();

        ListRestoranTerdekat.setOnItemClickListener((parent, view, position, id) -> {
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

        });
        loaditem();

//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            MenuInflater inflater = getMenuInflater();
//            inflater.inflate(R.menu.search_main, menu);
//
//            MenuItem searchViewItem = menu.findItem(R.id.search_bar);
//            SearchView searchView = MenuItemCompat.getActionView(searchViewItem);
//
//            searchView.setOnQueryTextListener(
//                    new SearchView.OnQueryTextListener() {
//
//                        // Override onQueryTextSubmit method
//                        // which is call
//                        // when submitquery is searched
//
//                        @Override
//                        public boolean onQueryTextSubmit(String query)
//                        {
//                            // If the list contains the search query
//                            // than filter the adapter
//                            // using the filter method
//                            // with the query as its argument
//                            if (ListRestoranTerdekat.contains(query)) {
//                                adapter.getFilter().filter(query);
//                            }
//                            else {
//                                // Search query not found in List View
//                                Toast.makeText(MainActivity.this, "Not found", Toast.LENGTH_LONG).show();
//                            }
//                            return false;
//                        }
//
//                        // This method is overridden to filter
//                        // the adapter according to a search query
//                        // when the user is typing search
//                        @Override
//                        public boolean onQueryTextChange(String newText)
//                        {
//                            adapter.getFilter().filter(newText);
//                            return false;
//                        }
//                    });
//
//            return super.onCreateOptionsMenu(menu);
//        }
    }

    private void loaditem() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_GetData_API, null, response -> {
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
        },
                error -> Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show());
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
