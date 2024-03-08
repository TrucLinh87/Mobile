package com.example.bt_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Objects> mObjects;
    public static final int TEXT = 0;
    public static final int IMAGE = 1;
    public static final int USER = 2;
    public  CustomAdapter(Context context, List<Objects> objects){
        mContext = context;
        mObjects = objects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(mContext);
        switch (viewType){
            case TEXT:
                View itemView0 = li.inflate(R.layout.row_text, parent, false);
            case IMAGE:
                View itemView1 = li.inflate(R.layout.row_image, parent, false);
            case USER:
                View itemView2 = li.inflate(R.layout.row_user, parent, false);
            default:
                break;


        }

        return null;
    }
    public int getItemViewType(int position) {
        Object item = mObjects.get(position);
        if(item instanceof  String){
            return TEXT;
        }else if(item instanceof Integer){
            return IMAGE;
        }else if(item instanceof UserModel){
            return USER;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            switch (getItemViewType(position)){
                case TEXT:
                    TextViewHolder textViewHolder = (TextViewHolder) holder;
                    textViewHolder.tvText.setText(mObjects.get(position).toString());
                    break;
                case IMAGE:
                    Object item = mObjects.get(position);
                    ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                    imageViewHolder.imvImage.setImageResource((int) item);
                    break;
                case USER:
                    Object item1 = mObjects.get(position);
                    UserModel user = (UserModel) item1;
                    UserViewHolder userViewHolder = (UserViewHolder) holder;
                    userViewHolder.tvName.setText(user.getName());
                    userViewHolder.tvAddress.setText(user.getAddress());
                    break;
            }
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }
    public class TextViewHolder extends RecyclerView.ViewHolder{

        private TextView tvText;
        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = (TextView) itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder{

        private ImageView imvImage;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imvImage = (ImageView) itemView.findViewById(R.id.imv_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvAddress;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Object item = mObjects.get(getAdapterPosition());
                    UserModel user = (UserModel) item ;
                    Toast.makeText(mContext, user.getName()+", "+ user.getAddress(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }




}
