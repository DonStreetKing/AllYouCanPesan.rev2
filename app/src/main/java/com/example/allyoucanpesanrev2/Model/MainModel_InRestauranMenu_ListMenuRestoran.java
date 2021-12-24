package com.example.allyoucanpesanrev2.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MainModel_InRestauranMenu_ListMenuRestoran implements Parcelable {
    private String Nama_Menu, Harga_Menu, Deskripsi_Menu;

    public MainModel_InRestauranMenu_ListMenuRestoran(String Nama_Menu, String Harga_Menu, String Deskripsi_Menu) {
        this.Nama_Menu = Nama_Menu;
        this.Harga_Menu = Harga_Menu;
        this.Deskripsi_Menu = Deskripsi_Menu;
    }

    public String getNama_Menu() {
        return Nama_Menu;
    }
    public String getHarga_Menu() {
        return Harga_Menu;
    }
    public String getDeskripsi_Menu() {
        return Deskripsi_Menu;
    }

    public void setNama_Menu(String nama_Menu) {
        Nama_Menu = Nama_Menu;
    }
    public void setHarga_Menu(String harga_Menu) {
        Harga_Menu = Harga_Menu;
    }
    public void setDeskripsi_Menu(String deskripsi_Menu) {
        Deskripsi_Menu = Deskripsi_Menu;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Nama_Menu);
        parcel.writeString(this.Harga_Menu);
        parcel.writeString(this.Deskripsi_Menu);
    }

    protected MainModel_InRestauranMenu_ListMenuRestoran(Parcel in){
        this.Nama_Menu = in.readString();
        this.Harga_Menu = in.readString();
        this.Deskripsi_Menu = in.readString();
    }

    public static final Parcelable.Creator<MainModel_InRestauranMenu_ListMenuRestoran> CREATOR = new Parcelable.Creator<MainModel_InRestauranMenu_ListMenuRestoran>() {

        @Override
        public MainModel_InRestauranMenu_ListMenuRestoran createFromParcel(Parcel source) {
            return new MainModel_InRestauranMenu_ListMenuRestoran(source);
        }
        @Override
        public MainModel_InRestauranMenu_ListMenuRestoran[] newArray(int size) {
            return new MainModel_InRestauranMenu_ListMenuRestoran[size];
        }
    };
}