package com.example.bt_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    Button btnThem, btnCapNhat;
    ArrayList <String> arrayList;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("PHP");
        arrayList.add("Kotlin");
        arrayList.add("Dart");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn môn: "+arrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn đang chọn môn ở vị trí thứ: " +position +" là môn "+ arrayList.get(position), Toast.LENGTH_SHORT).show();


                return false;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                arrayList.add(name);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(arrayList.get(position));
                vitri = position;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.set(vitri, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();

                return false;
            }
        });
    }
    public void AnhXa(){
        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editTextText);
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnCapNhat = (Button) findViewById(R.id.button2);
        arrayList = new ArrayList<>();
    }
}