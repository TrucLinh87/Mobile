package com.example.drawableclip;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView3);
        button = (Button) findViewById(R.id.button);
        imageView.setImageLevel(1000);
        final ClipDrawable clipDrawable = (ClipDrawable) imageView.getDrawable();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int cur = clipDrawable.getLevel();
                        if(cur >= 10000){
                            cur = 0;
                        }
                        imageView.setImageLevel(cur + 1000);
                        handler.postDelayed(this, 500);
                    }
                }, 2000);


            }
        });
    }
}