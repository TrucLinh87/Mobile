package com.example.bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    ConstraintLayout bg;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bg = (ConstraintLayout)
                findViewById(R.id.constraintLayout1);
        img1= (ImageView)
                findViewById(R.id.imageView1);
        bai1();
        bai2();
        bai3();
        bai4();
        bai5();
        bai6();
        bai7();
        bai8();
        bai9();
    }
    private void bai1(){
        img1.setImageResource(R.drawable.kotlin);
    }
    private  void bai2(){
        bg.setBackgroundColor(Color.YELLOW);
        bg.setBackgroundResource(R.drawable.back);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.back);
        arrayList.add(R.drawable.back1);
        arrayList.add(R.drawable.back2);
        arrayList.add(R.drawable.back4);
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));
    }
    private void bai3(){
        ImageView imageView = (ImageView) findViewById(R.id.imageButton1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.on);
                img1.getLayoutParams().width=550;
                img1.getLayoutParams().height=550;
            }
        });
    }
    private void bai4(){
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ //isChecked = true
                    Toast.makeText(MainActivity.this, "Wifi đang bật", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Wifi đang tắt",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void bai5(){
        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox);
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked){
                    bg.setBackgroundResource(R.drawable.back);
                }else{
                    bg.setBackgroundResource(R.drawable.back1);
                }
            }
        });
    }
    public void bai6(){
        radioGroup = (RadioGroup)
                findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//checkID trả về ID radio
                if(checkedId == R.id.radioButton){
                    bg.setBackgroundResource(R.drawable.back2);
                }else if(checkedId == R.id.radioButton2){
                    bg.setBackgroundResource(R.drawable.back4);
                }
            }
        });
    }
    private void bai7(){
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = progressBar.getProgress();
                progressBar.setProgress(current + 10);
            }
        });

    }
    private void bai8(){
        ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar2);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = progressBar1.getProgress();
//chạy đều đều >100 quay về 0
                if (current>= progressBar1.getMax()){
                    current=0;
                }
                progressBar1.setProgress(current + 10); //thiết lập progress
            }
        });
    }
    private void bai9(){
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//tự đếm progress
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();
//chạy đều đều >100 quay về 0
                        if (current>= progressBar.getMax()){
                            current=0;
                        }
                        progressBar.setProgress(current + 10); //thiết lập progress
                    }
                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this,"Hết giờ",Toast.LENGTH_LONG).show();
                    }
                };
                countDownTimer.start();
            }
        });
    }

}