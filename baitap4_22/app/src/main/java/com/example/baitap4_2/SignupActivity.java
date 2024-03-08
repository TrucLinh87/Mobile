package com.example.baitap4_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    EditText edtName, edtEmail, edtPassword;
    Intent intentSignup;
    ImageView imvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setupUI();
        setupProcess();
    }

    private void setupProcess() {
        setupCreateAccount();
    }

    public void setupCreateAccount() {
        imvRegister.setOnClickListener(v -> {
            try {
                String name = edtName.getText().toString(),
                        email = edtEmail.getText().toString(),
                        passw = edtPassword.getText().toString();

                if (name.length() == 0 || email.length() == 0 || passw.length() == 0) {
                    Toast.makeText(this, "Nhap lai", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    loadRegister();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public void loadRegister() {
        intentSignup = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intentSignup);
    }

    private void setupUI() {
        edtName = findViewById(R.id.editTextName);
        edtEmail = findViewById(R.id.editTextEmail1);
        edtPassword = findViewById(R.id.editTextpassword1);
        imvRegister = findViewById(R.id.imageView4
        );
    }
}