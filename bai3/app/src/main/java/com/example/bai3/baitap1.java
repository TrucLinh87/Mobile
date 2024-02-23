package com.example.bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class baitap1 extends AppCompatActivity {

    ArrayList<Integer> arrayList;
    ConstraintLayout bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baitap1);
        bg = (ConstraintLayout) findViewById(R.id.constraintLayout1);
        arrayList = new ArrayList<>();
        arrayList.add(R.drawable.back);
        arrayList.add(R.drawable.back1);
        arrayList.add(R.drawable.back2);
        arrayList.add(R.drawable.back4);
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));
    }
}