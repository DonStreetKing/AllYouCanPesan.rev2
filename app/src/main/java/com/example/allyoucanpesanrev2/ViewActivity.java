//package com.example.allyoucanpesanrev2;
//
//import android.view.MenuItem;
//import android.widget.SearchView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.view.MenuItemCompat;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.allyoucanpesanrev2.Adapter.AdapterSearch;
//import com.example.allyoucanpesanrev2.Adapter.HasilSearch;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//
//public class ViewActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
//    public static final String URL = "http://donstreetking.duckdns.org:8082/API/AllYouCanPesan/";
//    private List<HasilSearch> hasilSearches = new ArrayList<>();
//    private AdapterSearch viewAdapter;
//
//    @BindView(R.id.)
//
//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String newText) {
//        return false;
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(android.view.Menu menu) {
//        getMenuInflater().inflate(R.menu.search_main, menu);
//        final MenuItem item = menu.findItem(R.id.action_search);
//        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
//        searchView.setQueryHint("Cari Restoran");
//        searchView.setIconified(false);
//        searchView.setOnQueryTextListener(this);
//        return true;
//    }
//
//}