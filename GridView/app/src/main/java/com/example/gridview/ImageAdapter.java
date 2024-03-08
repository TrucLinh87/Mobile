package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Image>imageList;

    public ImageAdapter(Context context, int layout, List<Image> imageList) {
        this.context = context;
        this.layout = layout;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
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
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Viewholder viewholder;
        if(convertView == null){
            viewholder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewholder.imageView = (ImageView) convertView.findViewById(R.id.imageHinhanh);
            convertView.setTag(viewholder);
        }else{
            viewholder = (Viewholder) convertView.getTag();
        }
        Image image = imageList.get(position);
        viewholder.imageView.setImageResource(image.getHinhanh());

        return convertView;
    }
}
