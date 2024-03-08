package com.example.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button btnmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnmenu = (Button) findViewById(R.id.button);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     showMenu();
            }
        });
    }
    private void showMenu(){
        PopupMenu popupMenu = new PopupMenu(this, btnmenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.menuThem){
                    btnmenu.setText("Thêm");
                }else if(itemId == R.id.menuXoa){
                    btnmenu.setText("Xóa");
                }else if(itemId == R.id.menuSua){
                    btnmenu.setText("Sửa");
                }
                return false;
            }
        });
        popupMenu.show();
    }

}