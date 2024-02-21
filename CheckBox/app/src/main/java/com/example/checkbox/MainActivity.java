package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cbAndroid, cbIOS, cbPHP;
    Button bxacnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        bxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = "Bạn đã chọn môn học: ";
                if(cbAndroid.isChecked()){
                    monHoc += cbAndroid.getText() + "\n";
                }
                if(cbIOS.isChecked()){
                    monHoc += cbIOS.getText() + "\n";
                }
                if(cbPHP.isChecked()){
                    monHoc += cbPHP.getText() + "\n";
                }
                Toast.makeText(MainActivity.this, monHoc, Toast.LENGTH_SHORT).show();
            }
        });
//        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    Toast.makeText(MainActivity.this, "Bạn đã chọn Android", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "Bạn đã bỏ chọn Android", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
    private void AnhXa(){
        cbAndroid = (CheckBox) findViewById(R.id.checkBox);
        cbIOS = (CheckBox) findViewById(R.id.checkBox2);
        cbPHP = (CheckBox)  findViewById(R.id.checkBox3);
        bxacnhan = (Button) findViewById(R.id.button);
    }
}