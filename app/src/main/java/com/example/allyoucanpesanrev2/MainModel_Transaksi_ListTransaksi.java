package com.example.allyoucanpesanrev2;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MainModel_Transaksi_ListTransaksi implements Parcelable {
    private String Nama_Restoran, Tanggal_Beli, Total_Biaya;

    public MainModel_Transaksi_ListTransaksi(String Nama_Restoran, String Tanggal_Beli, String Total_Biaya) {
        this.Nama_Restoran = Nama_Restoran;
        this.Tanggal_Beli = Tanggal_Beli;
        this.Total_Biaya = Total_Biaya;
    }

    public String getNama_Restoran() {
        return Nama_Restoran;
    }
    public String getTanggal_Beli() {
        return Tanggal_Beli;
    }
    public String getTotal_Biaya() {
        return Total_Biaya;
    }

    public void setNama_Restoran(String nama_Restoran) {
        Nama_Restoran = Nama_Restoran;
    }
    public void setTanggal_Beli(String tanggal_Beli) {
        Tanggal_Beli = tanggal_Beli;
    }
    public void setTotal_Biaya(String total_Biaya) {
        Total_Biaya = total_Biaya;
    }

    @Override
            public int describeContents() {
        return 0;
    }

    @Override
            public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Nama_Restoran);
        parcel.writeString(this.Tanggal_Beli);
        parcel.writeString(this.Total_Biaya);
    }

    protected MainModel_Transaksi_ListTransaksi(Parcel in){
        this.Nama_Restoran = in.readString();
        this.Tanggal_Beli = in.readString();
        this.Total_Biaya = in.readString();
    }

    public static final Parcelable.Creator<MainModel_Transaksi_ListTransaksi> CREATOR = new Parcelable.Creator<MainModel_Transaksi_ListTransaksi>() {

        @Override
        public MainModel_Transaksi_ListTransaksi createFromParcel(Parcel source) {
            return new MainModel_Transaksi_ListTransaksi(source);
        }
        @Override
        public MainModel_Transaksi_ListTransaksi[] newArray(int size) {
            return new MainModel_Transaksi_ListTransaksi[size];
        }
    };
}