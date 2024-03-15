package com.example.bt_15_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import com.example.bt_15_3.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private UserModel userModel;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        userModel = new UserModel("Truc", "Linh");
        binding.setUser(userModel);
        userModel.setFirstName("Trúc");
        userModel.setLastName("Linh");

    }
}