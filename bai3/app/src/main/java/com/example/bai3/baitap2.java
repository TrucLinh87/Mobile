package com.example.bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class baitap2 extends AppCompatActivity {

    Switch sw;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baitap2);
        sw = (Switch) findViewById(R.id.switch1);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    constraintLayout.setBackgroundResource(R.drawable.back2);
                }else{
                    constraintLayout.setBackgroundResource(R.drawable.back4);
                }

            }
        });
    }
}