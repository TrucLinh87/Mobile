package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView, imageViewRotate, imageViewScale,imgTranslate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageViewRotate = (ImageView) findViewById(R.id.imageView2);
        imageViewScale = (ImageView) findViewById(R.id.imageView3);
        imgTranslate = (ImageView) findViewById(R.id.imageView4);
        final  Animation animationTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        imgTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationTranslate);
            }
        });
        final Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        imageViewScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationScale);
            }
        });

       final Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation);
            }
        });

       final Animation animationRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        imageViewRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationRotate);
            }
        });
    }
}