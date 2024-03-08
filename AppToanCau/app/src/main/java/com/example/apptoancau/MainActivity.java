package com.example.apptoancau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtThongtin;
    EditText edHoTen, edEmail, edSDT;
    Button btnOke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnOke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = edHoTen.getText().toString();
                String email = edEmail.getText().toString();
                String sdt = edSDT.getText().toString();
                String txtHello = getResources().getString(R.string.text_Hello);
                String txtEmail = getResources().getString(R.string.text_Email);
                String txtPhone = getResources().getString(R.string.text_Sodienthoai);
                txtThongtin.setText(txtHello+": " + hoTen + "\n"+ txtEmail + ": " + email + "\n" + txtPhone+ ": " + sdt);
            }
        });
    }

    private void AnhXa() {
        txtThongtin = (TextView) findViewById(R.id.textViewThongTin);
        edHoTen = (EditText) findViewById(R.id.editTextHovaTen);
        edEmail = (EditText) findViewById(R.id.editTextEmail);
        edSDT = (EditText) findViewById(R.id.editTextSDT);
        btnOke = (Button) findViewById(R.id.button);
    }
}