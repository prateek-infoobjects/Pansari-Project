package com.pansari.promoter.salesmodule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.pansari.promoter.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsListAdapter extends RecyclerView.Adapter<ItemsListAdapter.ItemsHolder> {

    private Context mContext;
    private List<SalesItems> itemsList;
    LayoutInflater inf;

    public ItemsListAdapter(List<SalesItems> list, Context context) {
        mContext = context;
        itemsList = list;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public ItemsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemsHolder(LayoutInflater.from(mContext).inflate(R.layout.store_items_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsHolder viewHolder, int i) {

        viewHolder.label.setText(itemsList.get(i).getItemName());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class ItemsHolder extends RecyclerView.ViewHolder {

        private TextView label;
        private EditText answer;

        public ItemsHolder(@NonNull View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.item_label);
            answer = itemView.findViewById(R.id.item_answer);
        }
    }


}
