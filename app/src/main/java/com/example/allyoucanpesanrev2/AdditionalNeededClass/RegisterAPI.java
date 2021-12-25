package com.example.allyoucanpesanrev2.AdditionalNeededClass;

import com.bumptech.glide.disklrucache.DiskLruCache;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("insert.php")
    Call<DiskLruCache.Value> daftar(@Field("npm") String npm,
                                    @Field("nama") String nama,
                                    @Field("kelas") String kelas,
                                    @Field("sesi") String sesi);

    @GET("view.php")
    Call<DiskLruCache.Value> view();

    @FormUrlEncoded
    @POST("update.php")
    Call<DiskLruCache.Value> ubah(@Field("npm") String npm,
                                  @Field("nama") String nama,
                                  @Field("kelas") String kelas,
                                  @Field("sesi") String sesi);


    @FormUrlEncoded
    @POST("delete.php")
    Call<DiskLruCache.Value> hapus(@Field("npm") String npm);

    @FormUrlEncoded
    @POST("search.php")
    Call<DiskLruCache.Value> search(@Field("search") String search);
}
