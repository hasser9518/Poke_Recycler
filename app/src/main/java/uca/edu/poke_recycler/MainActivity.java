package uca.edu.poke_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

import static uca.edu.poke_recycler.ItemAdapter.SPAN_COUNT_ONE;
import static uca.edu.poke_recycler.ItemAdapter.SPAN_COUNT_THREE;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private GridLayoutManager gridLayoutManager;
    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        initItemsData();

        gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT_ONE);
        itemAdapter = new ItemAdapter(items, gridLayoutManager);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private void initItemsData(){
        items = new ArrayList<>(1);
            items.add(new Item(R.drawable.bulbasaur, "Bulbasaur", "Pokemon de planta"));
            items.add(new Item(R.drawable.charmander, "Charmander", "Pokemon de fuego"));
            items.add(new Item(R.drawable.squirtle, "Bulbasaur", "Pokemon de agua"));
            items.add(new Item(R.drawable.pikachu, "Bulbasaur", "Pokemon electrico"));
            items.add(new Item(R.drawable.eevee, "Eevee", "Pokemon normal"));
            items.add(new Item(R.drawable.pidgeotto, "Pidgeotto", "Pokemon volador"));
            items.add(new Item(R.drawable.mewtwo, "Mewtwo", "Pokemon psiquico"));
            items.add(new Item(R.drawable.ponyta, "Ponyta", "Pokemon de fuego"));
            items.add(new Item(R.drawable.psyduck, "Psyduck", "Pokemon de agua"));
            items.add(new Item(R.drawable.charizard, "Charizard", "Pokemon de fuego"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.menu_switch_layout){
            switchLayout();
            switchIcon(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchLayout(){
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_ONE){
            gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
        }else {
            gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);
        }
        itemAdapter.notifyItemRangeChanged(0, itemAdapter.getItemCount());
    }

    private void switchIcon(MenuItem item){
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_THREE){
            item.setIcon(getResources().getDrawable(R.drawable.lista));
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.cuadricula));
        }
    }
}
