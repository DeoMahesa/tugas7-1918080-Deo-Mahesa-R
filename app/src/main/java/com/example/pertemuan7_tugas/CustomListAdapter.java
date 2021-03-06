package com.example.pertemuan7_tugas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Helm> Helm;
    public CustomListAdapter(Activity activity, List<Helm> Helm) {
        this.activity = activity;
        this.Helm = Helm;
    }
    @Override
    public int getCount() {
        return Helm.size();
    }
    @Override
    public Object getItem(int location) {
        return Helm.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView brand = (TextView)
                convertView.findViewById(R.id.text_brand);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Helm m = Helm.get(position);
        nama.setText("Nama  : "+ m.get_nama());
        brand.setText("Brand  : "+ m.get_brand());
        return convertView;
    }
}