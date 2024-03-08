package com.example.ung_dung_dem_ngay_xa_em;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnButton;
    TextView txtView;
    EditText edtNgay1, edtNgay2;
    SimpleDateFormat simpleDateFormat;

    Calendar calendar1, calendar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        edtNgay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ngay1();
            }
        });
        edtNgay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ngay2();
            }
        });
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soNgayXaNhau = (int)(calendar2.getTimeInMillis() - calendar1.getTimeInMillis())/(1000*60*60*24);
                txtView.setText("Số ngày xa nhau là: " + soNgayXaNhau);
            }
        });
    }
    public void AnhXa(){
        btnButton = (Button) findViewById(R.id.button);
        txtView = (TextView) findViewById(R.id.textView);
        edtNgay1 = (EditText) findViewById(R.id.editTextNgay1);
        edtNgay2 = (EditText) findViewById(R.id.editTextNgay2);
    }
    public void Ngay1(){
         calendar1 = Calendar.getInstance();
        int date = calendar1.get(Calendar.DATE);
        int month = calendar1.get(Calendar.MONTH);
        int year = calendar1.get(Calendar.YEAR);
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendar1.set(year, month, dayOfMonth);
                    edtNgay1.setText(simpleDateFormat.format(calendar1.getTime()));
            }
        },year, month, date);
        dialog.show();
    }
    public void Ngay2(){
        calendar2 = Calendar.getInstance();
        int year = calendar2.get(Calendar.YEAR);
        int month = calendar2.get(Calendar.MONTH);
        int date = calendar2.get(Calendar.DATE);
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar2.set(year, month, date);
                edtNgay2.setText(simpleDateFormat.format(calendar2.getTime()));
            }
        }, year, month, date);
        dialog.show();
    }
}