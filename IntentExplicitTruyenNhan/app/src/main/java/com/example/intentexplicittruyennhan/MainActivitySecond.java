package com.example.intentexplicittruyennhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivitySecond extends AppCompatActivity {

    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        txtView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("dulieu");
        if(bundle != null){
            String ten = bundle.getString("chuoi");
            int so = bundle.getInt("so");
            String[] array = bundle.getStringArray("Tinh");
            sinhVien sv = (sinhVien) bundle.getSerializable("sinhvien");
            txtView.setText(sv.getName()+"\n"+ten +"\n" + so + "\n"+array[0]+"\n");
        }

    }
}