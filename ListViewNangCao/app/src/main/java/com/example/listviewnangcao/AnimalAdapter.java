package com.example.listviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AnimalAdapter extends BaseAdapter {
    private Context context;
    private int hinh;
    private List<Animal> animalList;

    public AnimalAdapter(Context context, int hinh, List<Animal> animalList) {
        this.context = context;
        this.hinh = hinh;
        this.animalList = animalList;
    }

    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class Viewholder{
        ImageView imageView;
        TextView txtName, txtDescription;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if(convertView == null){
            viewholder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(hinh, null);
            viewholder.txtName = (TextView) convertView.findViewById(R.id.textView2);
            viewholder.txtDescription = (TextView) convertView.findViewById(R.id.textView);
            viewholder.imageView = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewholder);//giữ các việc ánh xạ
        }else{
            viewholder = (Viewholder) convertView.getTag();
        }
        Animal animal = animalList.get(position);
        viewholder.txtName.setText(animal.getName());
        viewholder.txtDescription.setText(animal.getDescription());
        viewholder.imageView.setImageResource(animal.getPosition());
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_test);
        convertView.startAnimation(animation);
        return convertView;
    }
}
