package com.example.bt_customeradaptergridview;

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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.textName = (TextView) convertView.findViewById(R.id.textViewTen);
            viewHolder.textDesc = (TextView) convertView.findViewById(R.id.textView2);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MonHoc monHoc = monHocList.get(position);
        viewHolder.textName.setText(monHoc.getName());
        viewHolder.textDesc.setText(monHoc.getDesc());
        viewHolder.imageView.setImageResource(monHoc.getPic());
        return convertView;
    }
    public class ViewHolder{
        TextView textName, textDesc;
        ImageView imageView;
    }
}
