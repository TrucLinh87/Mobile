package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    //String []bangChuCai = {"A","B", "C", "D", "E", "F", "J", "H", "I", "K", "L", "M", "N", "O", "P","Q", "R"};
    ArrayList<Image> images;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        images = new ArrayList<>();
        images.add(new Image("Hình ảnh 1", R.drawable.anh1));
        images.add(new Image("Hình ảnh 2", R.drawable.anh2));
        images.add(new Image("Hình ảnh 3", R.drawable.anh3));
        images.add(new Image("Hình ảnh 4", R.drawable.anh4));
        images.add(new Image("Hình ảnh 5", R.drawable.anh5));
        images.add(new Image("Hình ảnh 6", R.drawable.anh6));
        adapter = new ImageAdapter(this, R.layout.dong_hinh_anh, images);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, images.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
//        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, bangChuCai);
//        gridView.setAdapter(adapter);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}