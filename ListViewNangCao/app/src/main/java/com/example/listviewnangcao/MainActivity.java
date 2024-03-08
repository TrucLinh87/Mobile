package com.example.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Animal>animals;

    AnimalAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_item);
        animals = new ArrayList<>();
        animals.add(new Animal("Cọp", "Con vật hung dữ", R.drawable.cop));
        animals.add(new Animal("Rồng", "Biết bay", R.drawable.rong));
        animals.add(new Animal("Trâu", "Mạnh mẽ", R.drawable.trau));
        animals.add(new Animal("Cọp", "Con vật hung dữ", R.drawable.cop));
        animals.add(new Animal("Rồng", "Biết bay", R.drawable.rong));
        animals.add(new Animal("Trâu", "Mạnh mẽ", R.drawable.trau));
        animals.add(new Animal("Cọp", "Con vật hung dữ", R.drawable.cop));
        animals.add(new Animal("Rồng", "Biết bay", R.drawable.rong));
        animals.add(new Animal("Trâu", "Mạnh mẽ", R.drawable.trau));
        animals.add(new Animal("Cọp", "Con vật hung dữ", R.drawable.cop));
        animals.add(new Animal("Rồng", "Biết bay", R.drawable.rong));
        animals.add(new Animal("Trâu", "Mạnh mẽ", R.drawable.trau));
        animals.add(new Animal("Cọp", "Con vật hung dữ", R.drawable.cop));
        animals.add(new Animal("Rồng", "Biết bay", R.drawable.rong));
        animals.add(new Animal("Trâu", "Mạnh mẽ", R.drawable.trau));
        adapter = new AnimalAdapter(this, R.layout.style_animal, animals);
        listView.setAdapter(adapter);
    }
}