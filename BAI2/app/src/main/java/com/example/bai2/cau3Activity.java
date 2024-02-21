package com.example.bai2;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class cau3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tạo và nhập mảng ArrayList kiểu số
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(2);
        numberList.add(7);
        numberList.add(15);
        numberList.add(11);
        numberList.add(4);

        // In ra Log các số nguyên tố
        printPrimeNumbers(numberList);
    }

    private void printPrimeNumbers(ArrayList<Integer> numbers) {
        for (int number : numbers) {
            if (isPrime(number)) {
                Log.d("PrimeNumbers", String.valueOf(number));
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}