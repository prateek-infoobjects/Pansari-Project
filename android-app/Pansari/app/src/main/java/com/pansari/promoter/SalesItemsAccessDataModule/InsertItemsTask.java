package com.pansari.promoter.SalesItemsAccessDataModule;

import android.content.Context;
import android.os.AsyncTask;

import com.pansari.promoter.salesmodule.SalesItems;
import com.pansari.promoter.salesmodule.SalesPageTwo;

import java.util.List;

public class InsertItemsTask extends AsyncTask<Void, Void, Void> {

    private Context mContext;
    private List<SalesItems> salesItems;

    public InsertItemsTask(Context context, List<SalesItems> items) {
        mContext = context;
        salesItems = items;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        DatabaseHolder db = DatabaseHolder.getAppDatabase(mContext);
        db.userDao().insertAll(salesItems);
        return null;

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ((SalesPageTwo) mContext).itemsInserted();
    }
}
