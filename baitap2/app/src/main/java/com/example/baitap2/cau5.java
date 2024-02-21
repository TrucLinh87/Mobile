package com.example.baitap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class cau5 extends AppCompatActivity {

    TextView txtSoN;
    Button btnRnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau5);
        txtSoN = (TextView) findViewById(R.id.textView);
        btnRnd = (Button) findViewById(R.id.button2);
        Xuly();
    }

    public void Xuly(){
        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//tạo số ngẫu nhiên
                Random random = new Random();
                int number = random.nextInt(10);
                txtSoN.setText(number + ""); }});
    }
}