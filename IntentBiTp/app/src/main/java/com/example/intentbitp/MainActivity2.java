package com.example.intentbitp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Collections;

public class MainActivity2 extends Activity {

    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);

        Collections.shuffle(MainActivity.arrayList);
        int soDong = 5;
        int soCot = 3;
        for (int i = 1; i<= soDong; i++){
            TableRow tableRow = new TableRow(this);
            for(int j = 1; j<=soCot; j++){
                int vitri = soCot*(i - 1) + j - 1;
                ImageView imageView = new ImageView(this);
                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, r.getDisplayMetrics());
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                imageView.setLayoutParams(layoutParams);
                int idHinh = getResources().getIdentifier(MainActivity.arrayList.get(vitri), "drawable", getPackageName());

                imageView.setImageResource(idHinh);
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhchon", MainActivity.arrayList.get(vitri));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
            tableLayout.addView(tableRow);
        }
    }
}