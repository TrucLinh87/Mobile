package com.example.ngay1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvUser;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvUser = findViewById(R.id.rcv_user);
        userAdapter = new UserAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rcvUser.setLayoutManager(gridLayoutManager);
        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
    }

    private List<User> getListUser() {
        List<User> users = new ArrayList<>();
        users.add(new User(R.drawable.t1, "User name 1"));
        users.add(new User(R.drawable.t2, "User name 2"));
        users.add(new User(R.drawable.t3, "User name 3"));
        users.add(new User(R.drawable.t4, "User name 4"));
        users.add(new User(R.drawable.t1, "User name 1"));
        users.add(new User(R.drawable.t2, "User name 2"));
        users.add(new User(R.drawable.t3, "User name 3"));
        users.add(new User(R.drawable.t4, "User name 4"));
        users.add(new User(R.drawable.t1, "User name 1"));
        users.add(new User(R.drawable.t2, "User name 2"));
        users.add(new User(R.drawable.t3, "User name 3"));
        users.add(new User(R.drawable.t4, "User name 4"));
        users.add(new User(R.drawable.t1, "User name 1"));
        users.add(new User(R.drawable.t2, "User name 2"));
        users.add(new User(R.drawable.t3, "User name 3"));
        users.add(new User(R.drawable.t4, "User name 4"));
        return users;
    }
}