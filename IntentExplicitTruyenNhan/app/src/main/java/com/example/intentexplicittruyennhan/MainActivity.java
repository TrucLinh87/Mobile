package com.example.intentexplicittruyennhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivitySecond.class);
                Bundle bundle = new Bundle();
                String[] array = {"Tiền Giang", "Vũng Tàu", "Quảng Ngãi", "Đồng Nai"};
                sinhVien sv = new sinhVien("Trúc Linh", "2004");
                bundle.putString("chuoi", "Phạm Thị Trúc Linh");
                bundle.putInt("so", 2004);
                bundle.putStringArray("Tinh", array);
                bundle.putSerializable("sinhvien", sv);
                intent.putExtra("dulieu", bundle);
                startActivity(intent);
            }
        });
    }
}