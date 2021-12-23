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

public class Transaksi extends AppCompatActivity {
    public static final String URL_HistoriTransaksi_API = "http://donstreetking.duckdns.org:8082/API/AllYouCanPesan/Get_ListTransaksi.php";
//    private static final String URL_Sort_DESC = "http://donstreetking.duckdns.org:8082/API/AllYouCanPesan/Button_SortList_DESC.php";
    public MainModel_Transaksi_ListTransaksi HistoriTransaksiAPI;
    ListView ListHistoriTransaksi;
    private List<MainModel_Transaksi_ListTransaksi> HistoriTransaksi;
//    ImageButton TombolSort = (ImageButton) findViewById(R.id.TombolSort);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
        // Tombol Sort
//            TombolSort.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String URL_Sort_Desc = URL_Sort_DESC;
//                new RequestHandler().execute(URL_Sort_Desc);
//            }
//        });

        // Databases
        ListHistoriTransaksi = findViewById(R.id.ShowListTransaksi);
        HistoriTransaksi = new ArrayList<>();

        ListHistoriTransaksi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Transaksi.this, ConfirmPayment_QRCode.class);
                MainAdapter_Transaksi_ListTransaksi adapter = new MainAdapter_Transaksi_ListTransaksi(HistoriTransaksi, getApplicationContext());

                ListHistoriTransaksi.setAdapter(adapter);
                MainModel_Transaksi_ListTransaksi posisi = adapter.getItem(position);
                Bundle data = new Bundle();
                data.putString("Nama_Restoran", posisi.getNama_Restoran());
                data.putString("Tanggal_Beli", posisi.getTanggal_Beli());
                data.putString("Jumlah_Transaksi", posisi.getJumlah_Transaksi());
                data.putString("Status_Transaksi", posisi.getStatus_Transaksi());
                intent.putExtras(data);
                startActivity(intent);
            }
        });
        loaditem();
    }
    private void loaditem() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_HistoriTransaksi_API, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Log.d("JsonArray", response.toString());
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        HistoriTransaksiAPI = new MainModel_Transaksi_ListTransaksi(
                                jsonObject.getString("Nama_Restoran"),
                                jsonObject.getString("Tanggal_Beli"),
                                jsonObject.getString("Jumlah_Transaksi"),
                                jsonObject.getString("Status_Transaksi"));
                        HistoriTransaksi.add(HistoriTransaksiAPI);
                    }
                    final MainAdapter_Transaksi_ListTransaksi adapter = new MainAdapter_Transaksi_ListTransaksi(HistoriTransaksi, getApplicationContext());
                    ListHistoriTransaksi.setAdapter(adapter);
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