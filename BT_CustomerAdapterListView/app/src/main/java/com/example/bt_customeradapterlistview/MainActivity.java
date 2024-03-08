package com.example.bt_customeradapterlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<MonHoc>arrayList;
    MonHocAdapter monHocAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Java", "1 ngôn ngữ dài dòng", R.drawable.java));
        arrayList.add(new MonHoc("C#", "ngôn ngữ ra đời sớm hơn c++", R.drawable.ccc));
        arrayList.add(new MonHoc("PHP", "Ngôn ngữ lâu đời", R.drawable.php));
        monHocAdapter = new MonHocAdapter(MainActivity.this,R.layout.row_monhoc, arrayList);
        listView.setAdapter(monHocAdapter);
    }
}