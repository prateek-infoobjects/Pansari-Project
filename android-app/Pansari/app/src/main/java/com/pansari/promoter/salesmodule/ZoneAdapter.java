package com.pansari.promoter.salesmodule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pansari.promoter.R;

import java.util.ArrayList;

public class ZoneAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> zoneList;
    LayoutInflater inf;

    public ZoneAdapter(ArrayList<String> list, Context context) {
        mContext = context;
        zoneList = list;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return zoneList.size();
    }

    @Override
    public String getItem(int position) {
        return zoneList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inf.inflate(R.layout.spinnexml, null);
        TextView txtItem = (TextView) convertView.findViewById(R.id.spinitem);

        txtItem.setText(zoneList.get(position));


        return convertView;
    }
}
