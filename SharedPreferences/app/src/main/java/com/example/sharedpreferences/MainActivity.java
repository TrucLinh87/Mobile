package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName, editPassword;
    CheckBox checkBox;
    Button button;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        sharedPreferences = getSharedPreferences("tendangnhap", MODE_PRIVATE);
        editName.setText(sharedPreferences.getString("ten", ""));
        editPassword.setText(sharedPreferences.getString("matkhau", ""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked", false));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                if(name.equals("TrucLinh") && password.equals("08072004")){

                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                    if(checkBox.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("ten", name);
                        editor.putString("matkhau", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("ten");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void AnhXa(){
        editName = (EditText) findViewById(R.id.editTextName);
        editPassword = (EditText) findViewById(R.id.editTextPassword);
        button = (Button) findViewById(R.id.button);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
    }
}