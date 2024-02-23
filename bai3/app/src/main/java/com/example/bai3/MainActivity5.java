package com.example.bai3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    TextView txtView;
    EditText editText, editText1;
    Button btnButton, button;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        button = (Button) findViewById(R.id.button5);
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.setCanceledOnTouchOutside(false);
        txtView = dialog.findViewById(R.id.textViewHoso);
        editText = dialog.findViewById(R.id.editTextMSSV);
        editText1 = dialog.findViewById(R.id.editTextHoTen);
        btnButton = dialog.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialog();
            }
        });
        XacNhanXoa();

    }
    private void XacNhanXoa(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông báo");
        alert.setMessage("Bạn có muốn đăng xuất không");
        alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//lệnh nút có
            }
        });
        alert.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//lệnh nút không
            }
        });
        alert.show();
    }
    private void setDialog(){
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mssv = editText.getText().toString();
                String hoten = editText1.getText().toString();
                Toast.makeText(MainActivity5.this, mssv + "\n" + hoten, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}