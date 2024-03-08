package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSelect;
    ConstraintLayout Screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelect = (Button) findViewById(R.id.button);
        Screen = (ConstraintLayout) findViewById(R.id.manHinh);
        registerForContextMenu(btnSelect);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.menuXanhla){
            Screen.setBackgroundColor(Color.GREEN);
        }else if(itemId == R.id.menuXanhduong){
            Screen.setBackgroundColor(Color.BLUE);
        }else if(itemId == R.id.menuVang){
            Screen.setBackgroundColor(Color.YELLOW);
        }

        return super.onContextItemSelected(item);
    }
}