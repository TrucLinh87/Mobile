package com.example.intentbitp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageView imageView, imageView1;
    public static  ArrayList<String> arrayList;
    int REQUEST_CODE = 123;
    TextView textView;
    String tenhinhgoc ="";
    int total = 100;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView1 = (ImageView) findViewById(R.id.imageView2);
        textView = (TextView) findViewById(R.id.textView2);
        sharedPreferences = getSharedPreferences("LuuDiemSo", MODE_PRIVATE);
        total = sharedPreferences.getInt("DiemSo", 100);
        textView.setText(total + "");
        String [] ten = getResources().getStringArray(R.array.list_name);
        arrayList = new ArrayList<>(Arrays.asList(ten));
        //trộn mảng
        Collections.shuffle(arrayList);
        tenhinhgoc = arrayList.get(5);
        int idHinh = getResources().getIdentifier(arrayList.get(5), "drawable", getPackageName());
        imageView.setImageResource(idHinh);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, MainActivity2.class), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
            String tenhinhnhan = data.getStringExtra("tenhinhchon");
            int idHinhNhan = getResources().getIdentifier(tenhinhnhan, "drawable", getPackageName());
            imageView1.setImageResource(idHinhNhan);
            if (tenhinhgoc.equals(tenhinhnhan)){
                Toast.makeText(this, "Chính xác", Toast.LENGTH_SHORT).show();
                total += 10;
                luuDiemSo();
                new CountDownTimer(2000, 100){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Collections.shuffle(arrayList);
                        tenhinhgoc = arrayList.get(5);
                        int idHinh = getResources().getIdentifier(arrayList.get(5), "drawable", getPackageName());
                        imageView.setImageResource(idHinh);
                    }
                }.start();
            }else{
                Toast.makeText(this, "Sai rồi!!", Toast.LENGTH_SHORT).show();
                total -=10;
                luuDiemSo();
            }
            textView.setText(total + "");
        }
        if(requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Ban chua chon hinh", Toast.LENGTH_SHORT).show();
            total -= 15;
            luuDiemSo();
        }
        textView.setText(total+"");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.me){
            Collections.shuffle(arrayList);
            tenhinhgoc = arrayList.get(5);
            int idHinh = getResources().getIdentifier(arrayList.get(5), "drawable", getPackageName());
            imageView.setImageResource(idHinh);
        }


        return super.onOptionsItemSelected(item);
    }
    public void luuDiemSo(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("DiemSo", total);
        editor.commit();
    }
}