package com.example.baitap4_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    ImageView imvLogin;
    Button btnLogin;
    TextView tvRegister;
    Intent intentLogin, intentRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();
        setupProcess();
    }

    private void setupProcess() {
        setupLogin();
        setupRegister();
    }

    public void setupRegister() {
        tvRegister.setOnClickListener(v -> {
            intentRegister = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intentRegister);
        });
    }


    public void setupLogin() {
        imvLogin.setOnClickListener(v -> {
            try {
                String email = edtEmail.getText().toString(), password = edtPassword.getText().toString();
                if (email.equals("admin") && password.equals("admin")) {
                    Toast.makeText(this, "oke", Toast.LENGTH_SHORT).show();
                    intentLogin = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intentLogin);
                } else {
                    Toast.makeText(this, "sai tai khoan or password", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

    }

    public void setupUI() {
        edtEmail = findViewById(R.id.editTextEmail);
        edtPassword = findViewById(R.id.editTextPassWord);
        imvLogin = findViewById(R.id.imageView2);
        tvRegister = findViewById(R.id.textView3);

//        btnLogin = findViewById(R.id.button_login);
    }

}
