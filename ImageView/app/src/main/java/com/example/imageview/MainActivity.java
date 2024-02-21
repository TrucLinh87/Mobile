package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout manhinh;
    ArrayList<Integer> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manhinh = (ConstraintLayout) findViewById(R.id.ManHinh);
        manhinh.setBackgroundResource(R.drawable.background1);
       // manhinh.setBackgroundColor(Color.rgb(234, 34, 53));
        arr = new ArrayList<>();
        arr.add(R.drawable.background1);
        arr.add(R.drawable.background2);
        arr.add(R.drawable.background3);
        arr.add(R.drawable.background4);
        Random random = new Random();
        int vitri = random.nextInt(arr.size());
        manhinh.setBackgroundResource(arr.get(vitri));
    }
}