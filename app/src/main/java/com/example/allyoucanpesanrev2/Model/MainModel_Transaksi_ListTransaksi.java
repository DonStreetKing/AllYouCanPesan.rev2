package com.example.allyoucanpesanrev2.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MainModel_Transaksi_ListTransaksi implements Parcelable {
    private String Nama_Restoran, Tanggal_Beli, Jumlah_Transaksi, Status_Transaksi;

    public MainModel_Transaksi_ListTransaksi(String Nama_Restoran, String Tanggal_Beli, String Jumlah_Transaksi, String Status_Transaksi) {
        this.Nama_Restoran = Nama_Restoran;
        this.Tanggal_Beli = Tanggal_Beli;
        this.Jumlah_Transaksi = Jumlah_Transaksi;
        this.Status_Transaksi = Status_Transaksi;
    }

    public String getNama_Restoran() {
        return Nama_Restoran;
    }
    public String getTanggal_Beli() {
        return Tanggal_Beli;
    }
    public String getJumlah_Transaksi() {
        return Jumlah_Transaksi;
    }
    public String getStatus_Transaksi() {
        return Status_Transaksi;
    }

    public void setNama_Restoran(String nama_Restoran) {
        Nama_Restoran = nama_Restoran;
    }
    public void setTanggal_Beli(String tanggal_Beli) {
        Tanggal_Beli = tanggal_Beli;
    }
    public void setJumlah_Transaksi(String jumlah_Transaksi) {
        Jumlah_Transaksi = jumlah_Transaksi;
    }
    public void setStatus_Transaksi(String status_Transaksi) {
        Status_Transaksi = status_Transaksi;
    }

    @Override
            public int describeContents() {
        return 0;
    }

    @Override
            public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Nama_Restoran);
        parcel.writeString(this.Tanggal_Beli);
        parcel.writeString(this.Jumlah_Transaksi);
        parcel.writeString(this.Status_Transaksi);
    }

    protected MainModel_Transaksi_ListTransaksi(Parcel in){
        this.Nama_Restoran = in.readString();
        this.Tanggal_Beli = in.readString();
        this.Jumlah_Transaksi = in.readString();
        this.Status_Transaksi = in.readString();
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