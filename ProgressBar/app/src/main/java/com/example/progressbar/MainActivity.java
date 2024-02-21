package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button download;
    ProgressBar pbXuly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        download = (Button) findViewById(R.id.button);
        pbXuly = (ProgressBar) findViewById(R.id.progressBar2);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 10000: 10 giây tổng tgian đếm ngược
                //1000: 1giaays tgian lặp lại hành động
                CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int curr = pbXuly.getProgress();
                        if (curr >= pbXuly.getMax()) {
                            curr = 0;
                        }
                        pbXuly.setProgress(curr + 10);
                    }

                    @Override
                    public void onFinish() {
                        this.start();//chạy mãi
                        Toast.makeText(MainActivity.this, "Hết giờ", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();

            }
        });
    }
}