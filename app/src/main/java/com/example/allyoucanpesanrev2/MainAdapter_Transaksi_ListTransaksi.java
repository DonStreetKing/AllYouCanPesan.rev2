package com.example.allyoucanpesanrev2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class MainAdapter_Transaksi_ListTransaksi extends ArrayAdapter<MainModel_Transaksi_ListTransaksi> {
    private List<MainModel_Transaksi_ListTransaksi> HistoriTransaksi;
    private Context context;

    public MainAdapter_Transaksi_ListTransaksi(List<MainModel_Transaksi_ListTransaksi> historiTransaksi, Context context) {
        super(context, R.layout.isi_list_transaksi_di_transaksi, historiTransaksi);
        this.HistoriTransaksi = historiTransaksi;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View listViewItem = inflater.inflate(R.layout.isi_list_transaksi_di_transaksi, null, true);

        TextView TextToShowNamaRestoran = listViewItem.findViewById(R.id.TextToShow_NamaRestoran);
        TextView TextToShowTanggalBeli = listViewItem.findViewById(R.id.TextToShow_TanggalPembelian);
        TextView TextToShowTotalBiaya = listViewItem.findViewById(R.id.TextToShow_TotalBiaya);

        MainModel_Transaksi_ListTransaksi mainModel_transaksi_listTransaksi = HistoriTransaksi.get(position);

        TextToShowNamaRestoran.setText(mainModel_transaksi_listTransaksi.getNama_Restoran());
        TextToShowTanggalBeli.setText(mainModel_transaksi_listTransaksi.getTanggal_Beli());
        TextToShowTotalBiaya.setText(mainModel_transaksi_listTransaksi.getTotal_Biaya());
        return listViewItem;
    }
}