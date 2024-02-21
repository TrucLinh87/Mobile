package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class cau4 extends AppCompatActivity {
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4);

        init();
        process();
    }

    public void init(){
        txt = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.button2);
    }

    public void process(){
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Random rd = new Random();
               int num = rd.nextInt(10);
               ArrayList<Integer> a = new ArrayList<>();
               for(int i = 0; i < num; i++){
                   a.add(rd.nextInt(10));
               }

               for(int i= 0; i < num; i++){
                   if(isSquare(a.get(i))){
                       txt.setText(a.get(i) + " ");
                       Toast.makeText(getApplicationContext(), "This is prime : " + a.get(i), Toast.LENGTH_LONG).show();
                   }
               }
           }
       });
    }

    public boolean isSquare(Integer x){
        Double ans = Math.sqrt(x);
        return ans * ans == x;
    }

}