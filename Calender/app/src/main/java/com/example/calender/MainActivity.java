package com.example.calender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        Calendar calendar = Calendar.getInstance();
        textView.append(calendar.getTime()+ "\n");
        SimpleDateFormat ngaythangnam = new SimpleDateFormat("dd/MM/yyyy");
        textView.append(ngaythangnam.format(calendar.getTime()) + "\n");
        SimpleDateFormat giophutgiay = new SimpleDateFormat("hh:mm:ss");
        textView.append(giophutgiay.format(calendar.getTime()) + "\n");
    }
}