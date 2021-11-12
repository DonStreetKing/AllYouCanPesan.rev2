package com.example.allyoucanpesanrev2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainAdapter_Transaksi_ListTransaksi extends ArrayAdapter<String> {

    Context context;
    int[] GambarRestoran;
    String[] NamaRestoran;
    String[] TanggalPembelian;
    String[] JumlahPembelian;

    public MainAdapter_Transaksi_ListTransaksi(Context context, String[] NamaRestoran, int[] GambarRestoran, String[] TanggalPembelian, String[] JumlahPembelian) {
        super(context, R.layout.isi_list_transaksi_di_transaksi,R.id.NamaRestoran, NamaRestoran);
        this.context = context;
        this.GambarRestoran = GambarRestoran;
        this.NamaRestoran = NamaRestoran;
        this.TanggalPembelian = TanggalPembelian;
        this.JumlahPembelian = JumlahPembelian;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View SingleItem = convertView;
        MainModel_Transaksi_ListTransaksi holder = null;

        if (SingleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            SingleItem = layoutInflater.inflate(R.layout.isi_list_transaksi_di_transaksi, parent, false);
            holder = new MainModel_Transaksi_ListTransaksi(SingleItem);
            SingleItem.setTag(holder);
        }

        else {
            holder = (MainModel_Transaksi_ListTransaksi) SingleItem.getTag();
        }
        holder.GambarRestoran.setImageResource(GambarRestoran[position]);
        holder.NamaRestoran.setText(NamaRestoran[position]);
        holder.TextToShow_TanggalPembelian.setText(TanggalPembelian[position]);
        holder.TextToShow_TotalBiaya.setText(JumlahPembelian[position]);
        SingleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Anda tekan: "+NamaRestoran[position], Toast.LENGTH_SHORT).show();
            }
        });
        return SingleItem;
    }
}