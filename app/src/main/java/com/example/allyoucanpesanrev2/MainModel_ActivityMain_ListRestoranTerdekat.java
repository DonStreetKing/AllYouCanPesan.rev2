package com.example.allyoucanpesanrev2;

import android.os.Parcel;
import android.os.Parcelable;

public class MainModel_ActivityMain_ListRestoranTerdekat implements Parcelable {
    private String Nama_Restoran, Jarak_Restoran, Meja_Tersedia;

    public MainModel_ActivityMain_ListRestoranTerdekat(String Nama_Restoran, String Jarak_Restoran, String Meja_Tersedia) {
//        this.Gambar_Restoran = Gambar_Restoran;
        this.Nama_Restoran = Nama_Restoran;
        this.Jarak_Restoran = Jarak_Restoran;
        this.Meja_Tersedia = Meja_Tersedia;
    }

    public String getNama_Restoran() {
        return Nama_Restoran;
    }
//    public String getGambar_Restoran() {
//        return Gambar_Restoran;
//    }
    public String getJarak_Restoran() {
        return Jarak_Restoran;
    }
    public String getMeja_Tersedia() {
        return Meja_Tersedia;
    }

    public void setNama_Restoran(String Nama_Restoran) {
        this.Nama_Restoran = Nama_Restoran;
    }
//    public void setGambar_Restoran(String Gambar_Restoran) {
//        this.Gambar_Restoran = Gambar_Restoran;
//    }
    public void setJarak_Restoran(String Jarak_Restoran) {
        this.Jarak_Restoran = Jarak_Restoran;
    }
    public void setMeja_Tersedia(String Meja_Tersedia) {
        this.Meja_Tersedia = Meja_Tersedia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Nama_Restoran);
//        parcel.writeString(this.Gambar_Restoran);
        parcel.writeString(this.Jarak_Restoran);
        parcel.writeString(this.Meja_Tersedia);
    }

    protected MainModel_ActivityMain_ListRestoranTerdekat(Parcel in) {
        this.Nama_Restoran = in.readString();
//        this.Gambar_Restoran = in.readString();
        this.Jarak_Restoran = in.readString();
        this.Meja_Tersedia = in.readString();
    }

    public static final Parcelable.Creator<MainModel_ActivityMain_ListRestoranTerdekat> CREATOR = new Parcelable.Creator<MainModel_ActivityMain_ListRestoranTerdekat>() {

        @Override
        public MainModel_ActivityMain_ListRestoranTerdekat createFromParcel(Parcel source) {
            return new MainModel_ActivityMain_ListRestoranTerdekat(source);
        }
        @Override
        public MainModel_ActivityMain_ListRestoranTerdekat[] newArray(int size) {
            return new MainModel_ActivityMain_ListRestoranTerdekat[size];
        }
    };
}