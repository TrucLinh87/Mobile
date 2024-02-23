package com.example.bai3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    Button btnButton, btnButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btnButton = (Button) findViewById(R.id.button3);
        btnButton1 = (Button) findViewById(R.id.button4) ;
        registerForContextMenu(btnButton);
        registerForContextMenu(btnButton1);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopupMenu();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bt,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.menuSetting) {
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.menuShare){
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.menuLogout){
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    private void ShowPopupMenu(){
        PopupMenu popupMenu = new PopupMenu(this,btnButton);
        popupMenu.getMenuInflater().inflate(R.menu.menu_bt,popupMenu.getMenu());
//bắt sự kiện
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menuSetting) {
                    Toast.makeText(MainActivity4.this, "Bạn đang chọn Setting", Toast.LENGTH_LONG).show();
                } else if (item.getItemId() == R.id.menuShare) {
                    btnButton.setText("Chia sẻ");
                }else if (item.getItemId() == R.id.menuLogout){
                    Toast.makeText(MainActivity4.this, "Bạn đang chọn Logout", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        popupMenu.show();
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_bt,menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuSetting) {

            Toast.makeText(MainActivity4.this, "Bạn đang chọn Setting", Toast.LENGTH_LONG).show();
        }else if(item.getItemId() == R.id.menuShare) {
            btnButton.setText("Chia sẻ");
        }
        else if(item.getItemId() == R.id.menuLogout){
            Toast.makeText(this, "Bạn đang chọn Logout", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);

    }
}