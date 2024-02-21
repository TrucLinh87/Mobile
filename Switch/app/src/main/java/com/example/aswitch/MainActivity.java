package com.example.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch switWifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switWifi = (Switch) findViewById(R.id.switch1);
        switWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Bạn đã mở wifi", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Bạn đã tắt Wifi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}