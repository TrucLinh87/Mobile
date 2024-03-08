package com.example.bt_customeradapterlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonHocAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<MonHoc> monHocList;

    public MonHocAdapter(Context context, int layout, List<MonHoc> monHocList) {
        this.context = context;
        this.layout = layout;
        this.monHocList = monHocList;
    }

    @Override
    public int getCount() {
        return monHocList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.textName = (TextView) convertView.findViewById(R.id.textViewMonHoc);
            viewHolder.textDesc = (TextView) convertView.findViewById(R.id.textViewDesc);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MonHoc monHoc =  monHocList.get(position);
        viewHolder.textName.setText(monHoc.getName());
        viewHolder.textDesc.setText(monHoc.getDesc());
        viewHolder.imageView.setImageResource(monHoc.getPic());

        return convertView;
    }
    private class ViewHolder{
        TextView textName, textDesc;
        ImageView imageView;
    }
}
