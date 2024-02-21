package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cb1, cb2, cb3;
    SeekBar sk1, sk2, sk3;
    ImageButton imPlay;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sk1.setEnabled(false);// không chạm vào hình khi đứng yên cx như khi chạy
        sk2.setEnabled(false);
        sk3.setEnabled(false);
        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int num = 5;
                Random random = new Random();
                int one = random.nextInt(num);
                int two = random.nextInt(num);
                int three = random.nextInt(num);
                // kiểm tra xem ai win rồi thì dừng lại
                if(sk1.getProgress() >= sk1.getMax())
                {
                    this.cancel();
                    imPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "1 win", Toast.LENGTH_SHORT).show();
                    if(cb1.isChecked()){
                        soDiem += 10;
                    }else{
                        soDiem -= 10;
                    }
                    txtDiem.setText(soDiem+"");
                    EnableCheckBox();
                }
                if (sk2.getProgress() >= sk2.getMax()){
                    this.cancel();
                    imPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "2 win", Toast.LENGTH_SHORT).show();
                    if(cb2.isChecked()){
                        soDiem += 10;
                    }else{
                        soDiem -= 10;
                    }
                    txtDiem.setText(soDiem+"");
                    EnableCheckBox();
                }
                if (sk3.getProgress() >= sk3.getMax()){
                    this.cancel();
                    imPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "3 win", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked()){
                        soDiem += 10;
                    }else{
                        soDiem -= 10;
                    }
                    txtDiem.setText(soDiem+"");
                    EnableCheckBox();
                }
                sk1.setProgress(sk1.getProgress()+one);
                sk2.setProgress(sk2.getProgress()+two);
                sk3.setProgress(sk3.getProgress()+three);
            }

            @Override
            public void onFinish() {

            }
        };
        imPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked() || cb2.isChecked() || cb3.isChecked()){
                    sk1.setProgress(0);//quay về vị trí ban đầu sau 1 lần chơi
                    sk2.setProgress(0);
                    sk3.setProgress(0);
                    imPlay.setVisibility(View.INVISIBLE);// ẩn hiện nút bắt đầu
                    countDownTimer.start();
                    DisableCheckBox();
                }else{
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }
            }
        });

    }
    private void EnableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    private void DisableCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void Anhxa(){
        txtDiem =(TextView) findViewById(R.id.textViewDiem);
        cb1 = (CheckBox) findViewById(R.id.checkboxone);
        cb2 = (CheckBox) findViewById(R.id.checkboxtwo);
        cb3 = (CheckBox) findViewById(R.id.checkboxthree);
        sk1 = (SeekBar) findViewById(R.id.seekbarone);
        sk2 = (SeekBar) findViewById(R.id.seekbartwo);
        sk3 = (SeekBar) findViewById(R.id.seekbarthree);
        imPlay = (ImageButton) findViewById(R.id.buttonplay);
    }
}