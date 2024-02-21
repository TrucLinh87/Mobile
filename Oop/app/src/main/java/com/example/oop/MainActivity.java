package com.example.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SinhVien sinhVien = new SinhVien("Pham Thi Truc Linh","Tien Giang", 2004 );
        Toast.makeText(this, sinhVien.getName() + " _ " + sinhVien.getYear(), Toast.LENGTH_SHORT).show();
    }
}