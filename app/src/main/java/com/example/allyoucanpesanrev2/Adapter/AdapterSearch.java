//package com.example.allyoucanpesanrev2.Adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.allyoucanpesanrev2.MenuRestoran;
//import com.example.allyoucanpesanrev2.R;
//
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class AdapterSearch extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private Context context;
//    List<HasilSearch> hasilSearches;
//
//    public RecyclerViewAdapter(Context context, List<HasilSearch> hasilSearches) {
//        this.context = context;
//        this.hasilSearches = hasilSearches;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_hasil_search, parent, false);
//        ViewHolder holder = new ViewHolder(v);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//        // Get current position of item in RecyclerView to bind data and assign values from list
//        HasilSearch hasilSearch = hasilSearches.get(position);
//        holder.TextToShowNamaRestoran.setText(hasilSearch.Nama_Restoran);
//        holder.TextToShowJarakRestoranHome.setText("Size: " + hasilSearch.Jarak_Restoran);
//        holder.TextToShowMejaTersediaHome.setText("Category: " + hasilSearch.Meja_Tersedia);
//    }
//    @Override
//    public int getItemCount() {
//        return hasilSearches.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//        @BindView(R.id.TextToShow_NamaRestoran) TextView TextToShowNamaRestoran;
//        @BindView(R.id.TextToShow_JarakRestoranHome) TextView TextToShowJarakRestoranHome;
//        @BindView(R.id.TextToShow_MejaTersediaHome) TextView TextToShowMejaTersediaHome;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            String NamaRestoran = TextToShowNamaRestoran.getText().toString();
//            String JarakRestoran = TextToShowJarakRestoranHome.getText().toString();
//            String MejaTersedia = TextToShowMejaTersediaHome.getText().toString();
//
//            Intent intent = new Intent(context, MenuRestoran.class);
//            intent.putExtra("Nama_Restoran", NamaRestoran);
//            intent.putExtra("Jarak_Restoran", JarakRestoran);
//            intent.putExtra("Meja_Tersedia", MejaTersedia);
//            context.startActivity(intent);
//        }
//    }
//}
