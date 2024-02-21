package com.example.vd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtNoiDung;
    EditText edtNumber1, edtNumber2;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 =  edtNumber1.getText().toString();
                String chuoi2 = edtNumber2.getText().toString();
                if(chuoi1.length() == 0 || chuoi2.length() == 0){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập lại!!", Toast.LENGTH_SHORT).show();

                }else{
                    int so1 = Integer.parseInt(chuoi1);
                    int so2 = Integer.parseInt(chuoi2);
                    if(so1 >= so2){
                        Toast.makeText(MainActivity.this, "Vui lòng nhập lại!", Toast.LENGTH_SHORT).show();
                    }else{
                        Random random = new Random();
                        int number = random.nextInt(so2 - so1 + 1) + so1;
                        txtNoiDung.setText(String.valueOf(number));
                    }
                }
            }
        });
    }
    private void AnhXa(){
        txtNoiDung = (TextView) findViewById(R.id.textView2);
        btnClick = (Button) findViewById(R.id.button);
        edtNumber1 = (EditText) findViewById(R.id.editTextNumberOne);
        edtNumber2 = (EditText) findViewById(R.id.editTextNumberTwo);
    }
}