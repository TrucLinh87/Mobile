package com.example.ngay1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private Context mContext;
    private List<User> mlistUser;

    public UserAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<User> users){
        this.mlistUser = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mlistUser.get(position);
        if(user == null){
            return;
        }
        holder.imgUser.setImageResource(user.getResourceImage());
        holder.txtName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if(mlistUser != null){
            return mlistUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgUser;
        private TextView txtName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.img_user);
            txtName = itemView.findViewById(R.id.txt_user);
        }
    }
}
