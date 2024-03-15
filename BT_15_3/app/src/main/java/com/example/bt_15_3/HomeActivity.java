package com.example.bt_15_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.bt_15_3.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListUserAdapter listUserAdapter;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setLifecycleOwner(this); // Add this line if you're using LiveData
        setTitle("Ví dụ về DataBinding cho RecyclerView");
        setData();
        setupRecyclerView();
    }

    private void setData() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setFirstName("Trúc " + i); // Corrected concatenation
            user.setLastName("Linh " + i);  // Corrected concatenation
            userList.add(user);
        }
        listUserAdapter = new ListUserAdapter(userList);
    }

    private void setupRecyclerView() {
        binding.rcView.setLayoutManager(new LinearLayoutManager(this));
        binding.rcView.setAdapter(listUserAdapter);
        listUserAdapter.setOnItemClickListener(this::itemClick); // Lambda expression
    }

    public void itemClick(User user) {
        Toast.makeText(this, "Bạn vừa click vào " + user.getFirstName() + " " + user.getLastName(), Toast.LENGTH_SHORT).show();
    }
}
