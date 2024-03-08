package com.example.listview;

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

    ListView lvName;
    EditText ed;
    Button bnADD, bnUpdate;
    ArrayList<String>ds;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvName = (ListView) findViewById(R.id.listView);
        ed = (EditText) findViewById(R.id.editText);
        bnADD = (Button) findViewById(R.id.buttonADD) ;
        bnUpdate = (Button) findViewById(R.id.buttonUpdate);
        ds = new ArrayList<>();
        ds.add("Trúc Linh");
        ds.add("Thảo");
        ds.add("Chi");
        ds.add("Nga");
        ds.add("Chiến");
        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,ds);
        lvName.setAdapter(adapter);
//        // vừa chạm là hiện
//        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, ds.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
//        // chạm vào lâu
//        lvName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "Click: "+ ds.get(position), Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
            bnADD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ten = ed.getText().toString();
                    ds.add(ten);
                    adapter.notifyDataSetChanged();//cho thâý kết quả
                    Toast.makeText(MainActivity.this, "Đã thêm 1 tên", Toast.LENGTH_SHORT).show();
                }
            });
            //khi click vào nó sẽ hiện tên lên thanh công cụ
           lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   ed.setText(ds.get(position));
                   vitri = position;
               }
           });
           bnUpdate.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   ds.set(vitri, ed.getText().toString());
                   adapter.notifyDataSetChanged();
                   Toast.makeText(MainActivity.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
               }
           });
           lvName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
               @Override
               public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                   ds.remove(position);
                   adapter.notifyDataSetChanged();
                   return false;
               }
           });
    }
}