package com.example.baitap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class cau2 extends AppCompatActivity {
    Button btnDangnhap;
    EditText editName, editPass;
    TextView txtNoiDung1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cau2);
        btnDangnhap =(Button) findViewById(R.id.button);
        editName = (EditText) findViewById(R.id.editTextText2);
        editPass = (EditText) findViewById(R.id.editTextText);
        txtNoiDung1 = (TextView) findViewById(R.id.textView3);
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editName.getText().toString().equals("admin")
                        && editPass.getText().toString().equals("admin")){
                    editName.setVisibility(View.GONE);
                    editPass.setVisibility(View.GONE);
                    btnDangnhap.setVisibility(View.GONE);
                    txtNoiDung1.setText("Đăng nhập thành công!");
                }else {
                    if(!editName.getText().toString().equals("admin") && editPass.getText().toString().equals("admin")){
                        txtNoiDung1 .setText("Đăng nhập thất bại" + " " + "vui lòng nhập lại tên tài khoản");
                        editName.setText("");
                    }
                    else if(!editPass.getText().toString().equals("admin") && editName.getText().toString().equals("admin")){
                        txtNoiDung1.setText("Đăng nhập thất bại" + " " + "vui lòng nhập lại mật khẩu");
                        editPass.setText("");
                    }
                    else{
                        txtNoiDung1.setText("Đăng nhập thất bạid");
                        editName.setText("");
                        editPass.setText("");
                    }
                }
            }
        });
    }
}