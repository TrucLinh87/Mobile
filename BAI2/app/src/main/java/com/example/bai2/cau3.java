package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class cau3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);

        int n = 10;
        for(Integer i = 2; i < n; i++){
            if(isPrime(i)){
                Log.d("so nguyen to", i.toString());
            }
        }
    }
    static boolean isPrime(int x){
        for(int i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0)
                return false;
        }
        return x > 2;
    }
}