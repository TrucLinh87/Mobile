package com.example.dialogcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtThongbao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtThongbao = (TextView) findViewById(R.id.textViewThongBao);
        txtThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DialogLogin();
            }
        });
    }
    private void DialogLogin(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCanceledOnTouchOutside(false);
        EditText edtUsername = (EditText) dialog.findViewById(R.id.editTextUsername);
        EditText edtPassword = (EditText) dialog.findViewById(R.id.editTextPassword);
        Button btnDongy      = (Button) dialog.findViewById(R.id.buttonDongy);
        Button btnHuy        = (Button) dialog.findViewById(R.id.buttonHuy);

        btnDongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if(username.equals("Linh") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}