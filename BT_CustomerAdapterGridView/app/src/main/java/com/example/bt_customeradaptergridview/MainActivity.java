package com.example.bt_customeradaptergridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<MonHoc>arrayList;
    MonHocAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Java", "Dài dòng", R.drawable.java));
        arrayList.add(new MonHoc("PHP", "Ra đời sớm", R.drawable.php));
        arrayList.add(new MonHoc("C#", "window", R.drawable.ccc));
        arrayList.add(new MonHoc("C++", "Ra đời sau C#", R.drawable.chh));
        arrayList.add(new MonHoc("Kotlin", "Chưa tìm hiểu", R.drawable.kotlin));
        arrayList.add(new MonHoc("Dart", "Như trên", R.drawable.dart));
        adapter = new MonHocAdapter(MainActivity.this, R.layout.row_monhoc, arrayList);
        gridView.setAdapter(adapter);


    }
}