package com.pansari.promoter.SalesItemsAccessDataModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pansari.promoter.R;
import com.pansari.promoter.salesmodule.SalesItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 2/3/2016.
 */
public class ItemsNamesSpinnerAdapter extends BaseAdapter {

    Context context;
    List<SalesItems> ItemList;
    LayoutInflater inf;

    public ItemsNamesSpinnerAdapter(Context context, List<SalesItems> ItemList) {

        this.context = context;
        this.ItemList = ItemList;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return ItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inf.inflate(R.layout.spinnexml, null);
        TextView txtItem = (TextView) convertView.findViewById(R.id.spinitem);

        txtItem.setText(ItemList.get(position).getItemName());

        return convertView;
    }
}
