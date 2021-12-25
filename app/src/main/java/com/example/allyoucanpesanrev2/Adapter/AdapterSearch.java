package com.example.allyoucanpesanrev2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allyoucanpesanrev2.R;

import java.util.Collections;
import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<HasilSearch> data= Collections.emptyList();
    HasilSearch current;
    int currentPos=0;

    public AdapterSearch(Context context, List<HasilSearch> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    public RecyclerView.ViewHolder onCrateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_hasil_search, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        HasilSearch current=data.get(position);
        myHolder.TextToShowNamaRestoran.setText(current.Nama_Restoran);
        myHolder.TextToShowJarakRestoranHome.setText("Size: " + current.Jarak_Restoran);
        myHolder.TextToShowMejaTersediaHome.setText("Category: " + current.Meja_Tersedia);
//        myHolder.textPrice.setText("Rs. " + current.price + "\\Kg");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView TextToShowNamaRestoran;
        TextView TextToShowJarakRestoranHome;
        TextView TextToShowMejaTersediaHome;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            TextToShowNamaRestoran = (TextView) itemView.findViewById(R.id.TextToShow_NamaRestoran);
            TextToShowJarakRestoranHome = (TextView) itemView.findViewById(R.id.TextToShow_JarakRestoranHome);
            TextToShowMejaTersediaHome = (TextView) itemView.findViewById(R.id.TextToShow_MejaTersediaHome);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {

            Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();
        }
    }
}
