package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tn, menu);// hiê dấu 3 chấm trên thanh menu nếu
        //như đã nhập dòng này mà chạy không hiện thì vô phần theme xóa NoActionBar
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.menuSettings){
            Toast.makeText(this, "Bạn đã chọn Settings", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.menuFeedback){
            Toast.makeText(this, "Bạn đã chọn Feedback", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.menuContact){
            Toast.makeText(this, "Bạn đã chọn Contact", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.meunuEmail){
            Toast.makeText(this, "Bạn đã chọn Contact Email", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.meunuPhone){
            Toast.makeText(this, "Bạn đã chọn Contact Phone", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.menuHelp){
            Toast.makeText(this, "Bạn đã chọn Help", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}